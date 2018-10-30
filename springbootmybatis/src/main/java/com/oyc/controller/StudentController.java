package com.oyc.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.oyc.bean.FundPortfolio;
import com.oyc.bean.Student;
import com.oyc.service.StudentService;
import com.oyc.util.MongoGridFsTemplate;
import com.oyc.util.ParseXML;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    MongoGridFsTemplate mongoGridFsTemplate;

    // 获得SpringBoot提供的mongodb的GridFS对象
    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    GridFsOperations gridOperations;

    @GetMapping(value="/list")
    public String getList(ModelMap map, @ModelAttribute(value="student") Student student,
          @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
          @RequestParam(defaultValue = "8", value = "pageSize") Integer pageSize)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> list = studentService.getListByName(student.getName());
        PageInfo<Student> pageInfo = new PageInfo<>(list, 5);
        map.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        map.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        map.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        map.addAttribute("totalPages", pageInfo.getPages());
        // 总记录数
        map.addAttribute("totalNums", pageInfo.getTotal());
        map.addAttribute("navigatePages", pageInfo.getNavigatePages());
        //是否是最后一页
        map.addAttribute("isLastPage", pageInfo.isIsLastPage());
        map.addAttribute("studentList", pageInfo.getList());
        // int i = 1/0; afkslgflg,tlf
        return "student/list";
    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String add() {
        return "student/add";
    }

   /* @RequestMapping(value="/queryListByName", method = RequestMethod.GET)
    public String getStudentByName(@ModelAttribute(value="student") Student student, ModelMap map, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "8") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> list =  service.getListByName(student.getName());
        PageInfo<Student> pageInfo = new PageInfo<>(list, 5);
        map.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        map.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        map.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        map.addAttribute("totalPages", pageInfo.getPages());
        map.addAttribute("totalNums", pageInfo.getTotal());
        //是否是最后一页
        map.addAttribute("isLastPage", pageInfo.isIsLastPage());
        map.addAttribute("studentList", pageInfo.getList());
        return "student/list";
    }*/

    @ModelAttribute
    Student setStudent() { // 用到了 th:field 需要设置这个，否则报错
        return new Student();
    }

    @PostMapping(value="/addStudent")
    public String addStudent(@Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
//            StringBuffer sb = new StringBuffer();
//            List<ObjectError> list = result.getAllErrors();
//            for (ObjectError error : list) {
//                sb.append(((FieldError)error).getField() +" : ").append(error.getDefaultMessage());
//            }
            return "student/add";
        }
        Student stu = new Student();
        stu.setName(student.getName());
        stu.setAge(student.getAge());
        stu.setSex(student.getSex());
        stu.setCls(student.getCls());
        stu.setAddress(student.getAddress());
        studentService.addStudent(stu);

        return "redirect:/list";
    }

    @GetMapping(value="/update")
    public String update(@RequestParam int id, ModelMap map) {
        Student student = studentService.getStudentById(id);
        map.addAttribute("student", student);
        return "student/edit";
    }

    @PostMapping(value="/updateStudent")
    public String updateStudent(@Valid @ModelAttribute(value = "student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "student/edit";
        }
        Student stu = new Student();
        stu.setId(student.getId());
        stu.setName(student.getName());
        stu.setAge(student.getAge());
        stu.setSex(student.getSex());
        stu.setCls(student.getCls());
        stu.setAddress(student.getAddress());
        studentService.updateStudent(stu);

        return "redirect:/list";
    }

    @PostMapping(value="/deleteStudent")
    public void deleteStudent(@RequestParam int id, HttpServletResponse response) {
        studentService.deleteById(id);
    }

    /*public void list(HttpServletResponse response) {
       try {
            //设置页面不缓存
            response.setContentType("application/json");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out= null;
            out = response.getWriter();
            out.print(JSON.toJSON(service.getStudentList()).toString());
            out.fl ush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    @RequestMapping(value="/getRedisValue")
    @ResponseBody
    public String getRedisValue(@RequestParam String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return value;
    }

    @RequestMapping(value="/getRedisObj")
    @ResponseBody
    public Student getRedisObj() {
        ValueOperations<String, Student> operations = redisTemplate.opsForValue();
        Student stu = operations.get("redis");
        return stu;
    }

    @RequestMapping(value="/test")
    @ResponseBody
    public void testMongoDb(HttpServletResponse response) {

        GridFsResource[] resources = new GridFsResource[]{};
        try {
            resources = mongoGridFsTemplate.gridFsTemplate().getResources("*xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        for(GridFsResource resource : resources) {
            try {
                ParseXML parseXML = new ParseXML();
                Map<String, Object> map = parseXML.parse(resource.getInputStream());
                if(map != null) {
                    FundPortfolio fundPortfolio = (FundPortfolio) map.get("fundPortfolio");
                    System.out.println(fundPortfolio.getFundCode());
                    sb.append(fundPortfolio.getFundCode()).append(",,,");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        response.setContentType("application/json");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out= null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.print(sb.toString());
        out.flush();
        out.close();
    }

    private String imageFileId = "";

    @GetMapping("/save")
    public String saveFiles() throws FileNotFoundException {
        // Define metaData
        DBObject metaData = new BasicDBObject();
        metaData.put("organization", "JavaSampleApproach");

        /**
         * 1. save an image file to MongoDB
         */

        // Get input file
//        InputStream iamgeStream = new FileInputStream("D:\\JSA\\jsa-logo.png");
//
//        metaData.put("type", "image");
//
//        // Store file to MongoDB
//        imageFileId = gridOperations.store(iamgeStream, "jsa-logo.png", "image/png", metaData).getId().toString();
//        System.out.println("ImageFileId = " + imageFileId);

        /**
         * 2. save text files to MongoDB
         */

        // change metaData
        metaData.put("type", "data");
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = mongoClient.getDatabase("test");
        GridFSBucket bucket = GridFSBuckets.create(database, "xml");
        System.out.println(bucket.getBucketName());
        bucket.uploadFromStream("test1.xml", new FileInputStream("D:\\Test\\test1.xml"));
        bucket.uploadFromStream("test.xml", new FileInputStream("D:\\Test\\test.xml"));
        bucket.uploadFromStream("A.txt", new FileInputStream("D:\\Test\\A.txt"));

        // Store files to MongoDb
//        gridOperations.store(new FileInputStream("D:\\Test\\A.txt"), "A.txt", "text/plain", metaData);
//        gridOperations.store(new FileInputStream("D:\\Test\\B.txt"), "B.txt", "text/plain", metaData);



        return "redirect:/list";
    }
}

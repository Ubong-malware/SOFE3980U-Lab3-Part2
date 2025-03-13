package com.ontariotechu.sofe3980U;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BinaryAPIController {

    @GetMapping("/add")
    public String add(@RequestParam(name = "operand1") String operand1,
                      @RequestParam(name = "operand2") String operand2) {
        Binary num1 = new Binary(operand1);
        Binary num2 = new Binary(operand2);
        return Binary.add(num1, num2).getValue();
    }

    @GetMapping("/add_json")
    public ResponseEntity<Map<String, String>> addJson(@RequestParam(name = "operand1") String operand1,
                                                    @RequestParam(name = "operand2") String operand2) {
        Binary num1 = new Binary(operand1);
        Binary num2 = new Binary(operand2);
        Binary result = Binary.add(num1, num2);

        Map<String, String> response = new HashMap<>();
        response.put("operand1", operand1);
        response.put("operand2", operand2);
        response.put("result", result.getValue());
        response.put("operator", "add");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(name = "operand1") String operand1,
                           @RequestParam(name = "operand2") String operand2) {
        Binary num1 = new Binary(operand1);
        Binary num2 = new Binary(operand2);
        return Binary.multiply(num1, num2).getValue();
    }

    @GetMapping("/or")
    public String or(@RequestParam(name = "operand1") String operand1,
                     @RequestParam(name = "operand2") String operand2) {
        Binary num1 = new Binary(operand1);
        Binary num2 = new Binary(operand2);
        return Binary.or(num1, num2).getValue();
    }

    @GetMapping("/and")
    public String and(@RequestParam(name = "operand1") String operand1,
                      @RequestParam(name = "operand2") String operand2) {
        Binary num1 = new Binary(operand1);
        Binary num2 = new Binary(operand2);
        return Binary.and(num1, num2).getValue();
    }
}
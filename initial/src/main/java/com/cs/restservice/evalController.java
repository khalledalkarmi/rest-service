package com.cs.restservice;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
public class evalController {
    @RequestMapping("/eval")
    public String eval (@RequestParam String eval) throws UnsupportedEncodingException {
        if (!eval.isEmpty()) {
            try {
                double e = new ExpressionBuilder(eval).build().evaluate();
                return String.valueOf(e);
            } catch (Exception e) {
                return "failed";
            }
        } else {
            return "empty request";
        }
    }
}

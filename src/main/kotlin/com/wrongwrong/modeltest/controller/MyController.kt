package com.wrongwrong.modeltest.controller

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("my")
class MyController{
    @GetMapping
    fun myGetTest(model: Model): String{
        return "hello from spring boot"
    }
}
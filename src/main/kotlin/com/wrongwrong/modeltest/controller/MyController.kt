package com.wrongwrong.modeltest.controller

import com.wrongwrong.modeltest.model.MyModel
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("my")
class MyController{
    @GetMapping
    fun myGetTest(model: Model): String{
        return "hello from spring boot"
    }

    @PostMapping
    fun myPostTest(
            @RequestBody @Validated myModel: MyModel,
            bindingResult: BindingResult
    ): String {
        if(bindingResult.hasErrors()){
            return bindingResult.allErrors.toString() + "\n"
        }

        return "post:" + myModel.toString() + "\n"
    }
}
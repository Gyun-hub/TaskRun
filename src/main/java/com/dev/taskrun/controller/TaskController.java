package com.dev.taskrun.controller;

import com.dev.taskrun.service.AsyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/run")
public class TaskController {

    private final AsyncService asyncService;

    @RequestMapping("/async")
    public void asyncTest() {
        asyncService.doAsyncTask1();
        asyncService.doAsyncTask2();
    }
}

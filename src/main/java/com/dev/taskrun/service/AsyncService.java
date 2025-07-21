package com.dev.taskrun.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AsyncService {

    @Async
    public CompletableFuture<String> doAsyncTask1() {
        System.out.println("== doAsyncTask1 메인 시작 ==");

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("[doAsyncTask1] 5초 대기 중...");
            try {
                Thread.sleep(5000); // 5초 대기
                System.out.println("[doAsyncTask1] 5초 대기 끝");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        }).thenApply(result -> {
            System.out.println("[doAsyncTask1] 결과에 5 더하기");
            return result + 5;
        });

        System.out.println("== doAsyncTask1 메인 로직 진행 중 ==");

        // 결과가 준비될 때까지 기다림
        Integer finalResult = future.join();

        System.out.println("doAsyncTask1 최종 결과: " + finalResult);
        System.out.println("== doAsyncTask1 메인 종료 ==");

        return CompletableFuture.completedFuture("작업 완료");
    }

    @Async
    public CompletableFuture<String> doAsyncTask2() {

        System.out.println("== doAsyncTask2 메인 시작 ==");

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("[doAsyncTask2] 1초 대기 중...");
            try {
                Thread.sleep(1000); // 1초 대기
                System.out.println("[doAsyncTask2] 1초 대기 끝");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        }).thenApply(result -> {
            System.out.println("[doAsyncTask2] 결과에 5 더하기");
            return result + 5;
        });

        System.out.println("== doAsyncTask2 메인 로직 진행 중 ==");

        // 결과가 준비될 때까지 기다림
        Integer finalResult = future.join();

        System.out.println("doAsyncTask2 최종 결과: " + finalResult);
        System.out.println("== doAsyncTask2 메인 종료 ==");

        return CompletableFuture.completedFuture("작업 완료");
    }
}

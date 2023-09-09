package com.example.learn.aop;

import com.example.learn.entity.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class ProductAspect {
    @Before(value = "execution(* com.example.learn.controller.ProductController.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Request To " + joinPoint.getSignature() + " Started at " + new Date());
    }

    @After(value = "execution(* com.example.learn.controller.ProductController.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("Request To " + joinPoint.getSignature() + " Ended at " + new Date());
    }

    @Before(value = "execution(* com.example.learn.service.ProductService.*(..))")
    public void beforeAdviceForService(JoinPoint joinPoint) {
        System.out.println("Request To Service Layer " + joinPoint.getSignature() + " Started at " + new Date());
    }

    @After(value = "execution(* com.example.learn.service.ProductService.*(..))")
    public void afterAdviceForService(JoinPoint joinPoint) {
        System.out.println("Request To Service Layer " + joinPoint.getSignature() + " Ended at " + new Date());
    }

    @AfterReturning(value = "execution(* com.example.learn.service.ProductService.addProduct(..))", returning = "product")
    public void afterReturningAdviceForService(JoinPoint joinPoint, Product product) {
        System.out.println("Request To Service Add Layer  And Product Saved With Id :" + product.getId());
    }

    @AfterThrowing(value = "execution(* com.example.learn.service.ProductService.*(..))",throwing = "exception")
    public void afterThrowingAdviceForService(JoinPoint joinPoint ,Exception exception) {
        System.out.println("Request To Service  Layer  And Handle Throwing  " + exception.getMessage());
    }

}

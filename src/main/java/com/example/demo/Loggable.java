package com.example.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //სად გვინდა რომ ხელმისწავდომი იყოს ჩვენი ანოტაცია, ამ შემთხვევაში არის რანთაიმი
// გადავიმეოროთ ანოტაციები
@Target({ElementType.TYPE, ElementType.METHOD}) //ვაწერთ მხოლოდ ანოტაციას და მიუთითებს იმაზე თუ რას შეგვიძლია წავაწეროთ აქ არის ტიპები დამეთოდები
public @interface Loggable { }
package com.cheer.service;

import com.cheer.domain.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionService {

    public List<Question> getQuestion(){
        List<Question> list=new ArrayList<>();
        Question question1=new Question("下列做法哪些可以有效避免驾驶疲劳？","A、用餐不宜过饱","B、餐后适当休息后驾车",
                "C、保持良好的睡眠","D、连续驾驶不超过4小时","D");
        Question question2=new Question("夜间路边临时停车，以下做法错误的是什么？","A、开远光灯","B、不开启灯光",
                "C、开启示廓灯、后位灯","D、开危险报警闪光灯","B");
        Question question3=new Question("车辆发生“水滑”时，以下做法正确的是什么？","A、立刻猛踏制动踏板，降低车速",
                "B、不可急踩制动踏板","C、不得迅速转向","D、逐渐松抬加速踏板，让车速逐渐减缓","D");
        Question question4=new Question("机动车高速行驶中出现转向失控时，驾驶人要如何处置？","A、抢挂低速挡",
                "B、合理使用行车制动和驻车制动，避免紧急制动","C、紧急制动","D、开启危险报警闪光灯","B");
        Question question5=new Question("如图所示，驾驶机动车遇到对向来车正在强行超车时，以下做法正确的是什么？","A、向左打转向盘避让",
                "B、向右借用人行道避让","C、迎着来车鸣喇叭将其逼回","D、减速避让","D");
        Question question6=new Question("驾驶机动车在路口直行遇到这种信号灯应该怎样行驶？","A、进入路口等待","B、加速直行通过",
                "C、左转弯行驶","D、不得越过停止线","D");
        list.add(question1);
        list.add(question2);
        list.add(question3);
        list.add(question4);
        list.add(question5);
        list.add(question6);
       return list;
    }

}

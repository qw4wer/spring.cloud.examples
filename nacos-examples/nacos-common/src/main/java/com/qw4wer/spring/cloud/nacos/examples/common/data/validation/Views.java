package com.qw4wer.spring.cloud.nacos.examples.common.data.validation;

/**
 * @author chenjh
 * @desc 用于@jsonView的分组使用
 */
public interface Views {

    interface Base {
    }


    interface Add {
    }


    interface Update {
    }


    interface Delete {
    }


    interface BaseFirst extends Base {
    }


    interface BaseSecond extends Base {
    }


    interface BaseThird extends Base {
    }


    interface BaseFour extends Base {
    }

    interface BaseFive extends Base {
    }


}

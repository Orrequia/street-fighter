package com.restapisample.usecase;

import com.restapisample.pojo.Fighter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetFighters {

    public class Response {
        private List<Fighter> fighters;
    }
}

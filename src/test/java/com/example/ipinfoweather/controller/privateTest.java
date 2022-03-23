package com.example.ipinfoweather.controller;

import com.example.ipinfoweather.dto.ForeCastWeatherDTO;
import com.example.ipinfoweather.service.MainService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Ignore
@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class privateTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MainService mainService;

    @Test
    public void main() throws Exception {
//        ForeCastWeatherDTO foreCastWeatherDTO = new ForeCastWeatherDTO();
//        foreCastWeatherDTO.setCountry("KR");
//        String seoulL = "";
//        when(mainService.getWeather(null, null, seoulL)).thenReturn(foreCastWeatherDTO);
//        mockMvc.perform(get("/main"))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(view().name("index"));

    }


    @Test
    public void hello() throws Exception {
        //요청 "hello"
        //응답
        // - 모델 name : kk
        // - view 이름 : hello
       /* mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("name", "kk"))
                .andExpect(content().string(containsString("kk")));*/
        //html content안에 kk이 있는지 없는지
    }

}

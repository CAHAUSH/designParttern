package com.study.designpattern.chainOfresponsibility.v2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Request request = new Request();
        Response response = new Response();
        HtmlFilter htmlFilter = new HtmlFilter();
        SensitiveFilter sensitiveFilter = new SensitiveFilter();
        FilterChain filterChain = new FilterChain();
        filterChain.add(htmlFilter);
        filterChain.add(sensitiveFilter);
        filterChain.doFilter(request,response);
        System.out.println(request.getStr());
        System.out.println(response.getStr());
    }
}

interface Filter{
    void doFilter(Request request, Response res, FilterChain filterChain);
}

class HtmlFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.setStr(request.getStr()+"::HTML_Request");
        filterChain.doFilter(request,response);
        response.setStr(response.getStr()+"::HTML_response");
    }
}

class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.setStr(request.getStr()+"::Sensitive_Request");
        filterChain.doFilter(request,response);
        response.setStr(response.getStr()+"::Sensitive_response");
    }
}

class FilterChain{
    List<Filter> filters = new ArrayList<>();
    public void add(Filter filter){
        filters.add(filter);
    }
    private int index = 0;

    public void doFilter(Request request, Response res) {
        if(index<filters.size()){
            Filter filter = filters.get(index);
            index ++;
            filter.doFilter(request,res,this);
        }
    }
}

class Request{
    String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}

class Response{
    String str;
    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}

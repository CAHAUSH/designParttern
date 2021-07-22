package com.study.designpattern.chainOfresponsibility.v1;

public class Main {
    public static void main(String[] args) {
        Request request = new Request();
        Response response = new Response();
        HtmlFilter htmlFilter = new HtmlFilter();
        SensitiveFilter sensitiveFilter = new SensitiveFilter();
        htmlFilter.setNextFilter(sensitiveFilter);
        htmlFilter.doFilter(request,response);
        System.out.println(request.getStr());
        System.out.println(response.getStr());
    }
}

interface Filter{
    void doFilter(Request request, Response res);
    void setNextFilter(Filter filter);
}

class HtmlFilter implements Filter {
    Filter nextFilter;

    @Override
    public void doFilter(Request request, Response response) {
        request.setStr(request.getStr()+"::HTML_Request");
        if(nextFilter!=null){
            nextFilter.doFilter(request,response);
        }
        response.setStr(response.getStr()+"::HTML_response");
    }

    @Override
    public void setNextFilter(Filter filter) {
        this.nextFilter = filter;
    }
}

class SensitiveFilter implements Filter {

    Filter nextFilter;

    @Override
    public void doFilter(Request request, Response response) {
        request.setStr(request.getStr()+"::Sensitive_Request");
        if(nextFilter!=null){
            nextFilter.doFilter(request,response);
        }
        response.setStr(response.getStr()+"::Sensitive_response");
    }

    @Override
    public void setNextFilter(Filter filter) {
        this.nextFilter = filter;
    }


}

/*class FilterChain implements Filter{

    @Override
    public void doFilter(Request request, Response res) {

    }
}*/

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

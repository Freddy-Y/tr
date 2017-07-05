<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<footer>
        <div class="padding">
            <div class="main">
                <div class="container_12">
                    <div class="wrapper">
                        <article class="grid_8">
                            <h4>告诉我们您的建议</h4>
                            <form action="AddMassageServlet"  method="post" id="contact-form"><!--  id="contact-form" -->
                                    <textarea name="massage" rows="10" cols="60">留言需求</textarea><!-- onBlur="if(this.value=='') this.value='Message'" onFocus="if(this.value =='Message' ) this.value=''"  -->
                                    <div class="buttons">
                                        <input type="submit" value="提交">
                                    </div>											          
                            </form>
                        </article>
                        <div class="copyright">ysu.teachingresource © 2017<a href="admin/login.jsp">|管理员登陆</a></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
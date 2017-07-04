<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<footer>
        <div class="padding">
            <div class="main">
                <div class="container_12">
                    <div class="wrapper">
                        <article class="grid_8">
                            <h4>告诉我们您的建议</h4>
                            <form id="contact-form" method="post">
                                <fieldset>
                                    <textarea onBlur="if(this.value=='') this.value='Message'" onFocus="if(this.value =='Message' ) this.value=''">留言需求</textarea>
                                    <div class="buttons">
                                        <a href="#" onClick="document.getElementById('contact-form').reset()">重置</a>
                                        <a href="#" onClick="document.getElementById('contact-form').submit()">发送</a>
                                    </div>											
                                </fieldset>           
                            </form>
                        </article>
                        <div class="copyright">ysu.teachingresource © 2017</div>
                        <a href="admin/login.jsp">|管理员登陆</a>
                    </div>
                </div>
            </div>
        </div>
    </footer>
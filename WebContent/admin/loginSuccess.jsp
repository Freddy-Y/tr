<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>管理员</title>
<link href="${pageContext.request.contextPath}/admin/style.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/two.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/two.js"></script>
<script type="text/javascript">
	$(function(){
	var thisTime;
	$('.nav-ul li').mouseleave(function(even){
			thisTime	=	setTimeout(thisMouseOut,1000);
	})

	$('.nav-ul li').mouseenter(function(){
		clearTimeout(thisTime);
		var thisUB	=	$('.nav-ul li').index($(this));
		if($.trim($('.nav-slide-o').eq(thisUB).html()) != "")
		{
			$('.nav-slide').addClass('hover');
			$('.nav-slide-o').hide();
			$('.nav-slide-o').eq(thisUB).show();
		}
		else{
			$('.nav-slide').removeClass('hover');
		}
		
	})
	
	function thisMouseOut(){
		$('.nav-slide').removeClass('hover');
	}
	 
	$('.nav-slide').mouseenter(function(){
		clearTimeout(thisTime);
		$('.nav-slide').addClass('hover');
	})
	$('.nav-slide').mouseleave(function(){
		$('.nav-slide').removeClass('hover');
	})

})
</script>
</head>
<body>
	<div class="header">
		<div style="margin-left:60px;">
			<jsp:include page="/admin/header.jsp" flush="true"/>
		</div>
		<div style="float:left;">
			<!-- ========================================================= -->
	        <div class="nav-main" style="margin-top:110px;">
    	        <div class="nav-box">
    	            <div class="nav">
                      	<ul class="nav-ul">
                      		<li><a href="#" class="home"><span>设备管理</span></a></li>
                      		<li><a href="#" class="develop"><span>用户管理</span></a></li>
                      		<li><a href="#" class="wechat"><span>维修管理</span></a></li>
                      		<li><a href="#" class="case"><span>公告管理</span></a></li>
                      		<li><a href="#" class="news"><span>留言管理</span></a></li>
                     	 </ul>
                    </div>
                    <div class="nav-slide">
                        	<div class="nav-slide-o">
                                <li><a href="${pageContext.request.contextPath}/admin/equip/select.jsp" target="content"><span>设备状态</span></a></li>
                                <li><a href="${pageContext.request.contextPath}/admin/equip/add.jsp" target="content"><span>设备添加</span></a></li>
                            </div>
                        	<div class="nav-slide-o">
                        	<ul>
                        		<li><a href="${pageContext.request.contextPath}//signin.jsp" target="content"><span>添加用户</span></a></li>
                        		
                        		<li><a href="${pageContext.request.contextPath}/admin/user/select.jsp" target="content"><span>所有用户</span></a></li>
                        		
                        		
                        	</ul>	
                        </div>
                        <div class="nav-slide-o">
                        	<ul>
                        		<li><a href="${pageContext.request.contextPath}/admin/repair/add.jsp" target="content"><span>添加维修信息</span></a></li>
                        		<li><a href="${pageContext.request.contextPath}/admin/repair/select.jsp" target="content"><span>更新维修信息</span></a></li>
                        	</ul>
                        </div>
                        <div class="nav-slide-o">
                        	<ul>
                        		<li><a href="${pageContext.request.contextPath}/admin/report/select.jsp" target="content"><span>查看公告</span></a></li>
                        		<li><a href="${pageContext.request.contextPath}/admin/report/add.jsp" target="content"><span>添加公告</span></a></li>
                        
                        	</ul>
                        </div>
                        <div class="nav-slide-o">
                        	<ul>
                        		<li><a href="${pageContext.request.contextPath}/admin/massage/select.jsp" target="content"><span>查看留言</span></a></li>
                      
                        	</ul>
                        </div>
                    </div>
                </div>
            </div>

	<!-- ========================================================= -->

	</div>
    <div style="float:right;">
	   <iframe name="content" width="1800" height="750" src="${pageContext.request.contextPath}/admin/equip/select.jsp">
           123
       </iframe>
    </div>

</div>

<hr />
<div id="footer">
	<p class="legal">&copy;2017 Designed by ysu</p>
</div>
</body>
</html>

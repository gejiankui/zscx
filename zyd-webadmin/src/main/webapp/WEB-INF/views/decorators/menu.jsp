<div id="nav">
	<div id="dynamicMenu" class="noPrint">
		<ul class="menuList">		
			<!-- 微信菜单 -->				
			<li class="menubarex1">
			<a href="<c:url value='/weixinMenu/initWeixinMenu.do'/>" title="<spring:message code='menu.menuManage'/>" class="standalone">
			<div>
			 <spring:message code="menu.menuManage" />
			</div>
		    </a>
			</li>
			<!-- 回复设置 -->
            <li class="menubarex1">
	            <a href="<c:url value='/reply/initReply.do'/>" title="<spring:message code='menu.replyManage'/>" class="standalone">
	                <div>
	                   <spring:message code="menu.replyManage" />
	                </div>
	            </a>
            </li>
			<!-- 系统控制参数 -->
			<li class="menubarex1">
				<a href="<c:url value='/ctrlParam/initCtrlParam.do'/>" title="<spring:message code='menu.ctrlParam'/>" class="standalone">
					<div>
					     <spring:message code="menu.ctrlParam" />
					</div>
				</a>
			</li>	
			<!-- 问答管理-->
            <li class="menubarex1">
                <a href="<c:url value='/questions/searchQuesiton.do'/>" title="<spring:message code='menu.question'/>" class="standalone">
                   <div>
                       <spring:message code="menu.question" />
                   </div>
                </a>
            </li>
            <%-- <!-- 问答分类管理-->
            <li class="menubarex1">
                <a href="<c:url value='/questionKind/init.do'/>" title="<spring:message code='menu.questionKind'/>" class="standalone">
                   <div>
                       <spring:message code="menu.questionKind" />
                   </div>
                </a>
            </li> --%>
            <!-- 历史资讯管理-->
            <li class="menubarex1">
                <a href="<c:url value='/news/searchNews.do'/>" title="<spring:message code='menu.news'/>" class="standalone">
                   <div>
                       <spring:message code="menu.news" />
                   </div>
                </a>
            </li>
             <!-- 历史资讯分类管理-->
            <li class="menubarex1">
                <a href="<c:url value='/newsCategory/init.do'/>" title="<spring:message code='menu.categoryNews'/>" class="standalone">
                   <div>
                       <spring:message code="menu.categoryNews" />
                   </div>
                </a>
            </li>
            <!-- 活动管理 -->
            <li class="menubarex1">
                <a href="<c:url value='/active/search.do'/>" title="<spring:message code='menu.activity'/>" class="standalone">
                   <div>
                       <spring:message code="menu.activity" />
                   </div>
                </a>
            </li>  
		    <%-- <!-- 关于宁供-->
            <li class="menubarex1">
	            <a href="<c:url value='/about/initEdit.do'/>" title="<spring:message code='menu.aboutUs'/>" class="standalone">
	               <div>
	                   <spring:message code="menu.aboutUs" />
	               </div>
	            </a>
            </li>  --%>
			<!-- 登出 -->
			<li class="menubarex1">
				<a href="<c:url value='/login/logout.do'/>" title="<spring:message code='menu.logout'/>" class="standalone">
					<div>
					    <spring:message code="menu.logout" />
					</div>
				</a>
			</li>
			
			<!-- 今日推荐 -->
			<li class="menubarex1">
				<a href="<c:url value='/commendt/search.do'/>" title="<spring:message code='menu.commendToday'/>" class="standalone" >
				<div>
				    <spring:message code="menu.commendToday" />
				</div>
				</a>
			</li>
			
			<li><div class="bottomLine">&nbsp;</div></li>
			
		</ul>
	</div>
</div>

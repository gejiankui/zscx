
        <%@ include file="/WEB-INF/views/common/jsClock.jsp"%>
<div id="masthead">
    <div id="mastheadWrapper">
        <div class="logoInfo">
        </div>
        <div id="headerContent">
            <div class="group">
                <table>
                    <tbody>
                    <tr>
                        <td class="whitedata"><spring:message code="header.hello"/>,&nbsp;<c:out value="${sessionScope.COMMON_PARAM.ngAdminUserHolder.userName}" />&nbsp;!</td>
                    </tr>
                    <tr>
                        <td class="whitedata"><spring:message code="header.preLoginDate"/>&nbsp;:&nbsp;<fmt:formatDate value="${sessionScope.COMMON_PARAM.ngAdminUserHolder.formatLastLogin}"  pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
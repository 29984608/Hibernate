<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上架商品界面</title>
    <script type="text/javascript">
        function changeMold(){
            var sort=document.getElementById("selSort").value;

            //声明一个数组对象
            var MoldList=new Array();
            //alert(sort);
            MoldList[1]=['玫瑰长盒','玫瑰手捧',];
            MoldList[2]=['音乐玫瑰','玫瑰原盒','玫瑰方盒','玫瑰心形盒'];
            MoldList[3]=['项链','手链','首饰','对戒','套装'];

            var MoldList2=new Array();
            MoldList2[1]=['1','2'];
            MoldList2[2]=['3','4','5','6'];
            MoldList2[3]=['13','14','15','16'];


            var CatenaList=new Array();
            CatenaList[1]=['恒久真爱','LINE FRIENDS 专属','爱在满怀','星座经典','love oseonly'];
            CatenaList[2]=['星座经典','为爱而生','经典持续','满满的爱','love oseonly','全世爱','甜蜜心动','一生一世','诗意童话'];
            CatenaList[3]=['玫瑰经典','星座经典','生辰石','恒久经典','全心全意','时光无痕','玫瑰饰品','幸运精灵','时光之吻','爱之赞礼','全心全意','心心相印','love oseonly'];

            document.getElementById("selMold").options.length=1;
            document.getElementById("selCatena").options.length=1;
            //声明一个Option对象
            var op;
            //遍历cityList每个元素的子元素
            for(var i in MoldList[sort]){
                op=new Option(MoldList[sort][i ],MoldList[sort][i]);
                document.getElementById("selMold").options.add(op);
            }
            var op2;
            for(var j in CatenaList[sort]){
                op2=new Option(CatenaList[sort][j],CatenaList[sort][j]);
                document.getElementById("selCatena").options.add(op2);
            }

            //alert(sort);
        }
    </script>
</head>
<body>
<%-- <%
	String path = request.getServletContext().getContextPath();
%> --%>
<form action="${pageContext.request.contextPath}/PutawayServlet" >
    <table border="1" align="center">
        <tr>
            <td>name</td>
            <td><input name="name"/></td>
        </tr>
        <tr>
            <td>description描述</td>
            <td><input name="description"/></td>
        </tr>
        <tr>
            <td>price价格</td>
            <td><input name="price"/></td>
        </tr>
        <tr>
            <td>color颜色</td>
            <td><input name="color"/></td>
        </tr>
        <tr>
            <td>texture材质</td>
            <td><input name="texture"/></td>
        </tr>
        <tr>
        <tr>
            <td>sort_id总类型</td>
            <td>
                <select id="selSort" onChange="changeMold()">
                    <option selected="selected">---选择类型---</option>
                    <option value="1" >鲜花玫瑰</option>
                    <option value="2">永生玫瑰</option>
                    <option value="3">玫瑰珠宝</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>mold_id类型</td>
            <td>
                <select id="selMold">
                    <option>---选择类型---</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>catena_id系列</td>
            <td>
                <select id="selCatena">
                    <option>---选择类型---</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>img</td>
            <td><input type="text" name="img"/></td>
        </tr>
        <tr>
            <td>sales库存</td>
            <td><input name="sales"/></td>
        </tr>
        <tr>
            <td>putaway是否在售</td>
            <td><input name="putaway"/></td>
        </tr>
    </table>
    <button>提交</button>
</form>

</body>
</html>

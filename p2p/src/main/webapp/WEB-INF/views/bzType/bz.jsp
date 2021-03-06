<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>标种</title>
    <%@include file="../master/easyui/header.jsp" %>
</head>
<body>
<table id="list" class="easyui-datagrid"
       data-options="
			toolbar:'#tb',
			rownumbers:true,
			border:false,
			singleSelect:true,
			pagination:true,
			pageNo:1,
			pageSize:10,
			url:'<%=path %>/bz/pager',
			method:'post'">
    <thead>
    <tr>
        <th data-options="field:'bzid',width:80,checkbox:true">编号</th>
        <th data-options="field:'bzname',width:100">标种名称</th>
        <th data-options="field:'stateToStr',width:100">标种状态</th>
    </tr>
    </thead>
</table>

<div id="tb" style="height: auto">
    <shiro:hasPermission name="bz:save">
        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" onclick="openWin('addWin');">添加</a>
    </shiro:hasPermission>
    <shiro:hasPermission name="bz:update">
        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEditWin('editWin', 'list', 'editForm')">修改</a>
    </shiro:hasPermission>
    <shiro:hasPermission name="bz:delete">
        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" onclick="deleteWin('list');">删除</a>
    </shiro:hasPermission>

</div>

<div id="addWin" class="easyui-window normal_win" data-options="title:'添加标种', closed:true">
    <form id="addForm">
        <table>
            <tr>
                <td>标种名称</td>
                <td>
                    <input class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入标种名称',
						required:true,
						validType:['length[2,20]'],
						novalidate:true" name="bzname"/>
                </td>
            </tr>
            <tr>
                <td>状态</td>
                <td>
                    <%--<input class="easyui-combobox easyui-validatebox state" data-options="prompt:'请选择状态',--%>
                    <%--required:true,--%>
                    <%--novalidate:true" name="state"/>--%>
                    <select id="state" class="easyui-combobox easyui-validatebox state" name="state"
                            style="width:174px;">
                        <option value="0" selected>可用</option>
                        <option value="1">不可用</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><a class="easyui-linkbutton" onclick="save('/bz/save', 'addForm', 'addWin', 'list');">确认</a></td>
            </tr>
        </table>
    </form>
</div>

<div id="editWin" class="easyui-window normal_win" data-options="title:'编辑标种', closed:true">
    <form id="editForm">
        <input type="hidden" name="bzid" id="bzid"/>
        <table>
            <tr>
                <td>标种名称</td>
                <td>
                    <input id="bzname" class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入标种名称',
						required:true,
						validType:['length[2,20]'],
						novalidate:true" name="bzname"/>
                </td>
            </tr>
            <tr>
                <td>状态</td>
                <td>
                    <%--<input id="state" class="easyui-combobox easyui-validatebox state" data-options="prompt:'请选择状态',--%>
                    <%--required:true,--%>
                    <%--novalidate:true" name="state"/>--%>
                    <select id="state" class="easyui-combobox easyui-validatebox state" name="state"
                            style="width:174px;">
                        <option value="0">可用</option>
                        <option value="1">不可用</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><a class="easyui-linkbutton" onclick="edit('/bz/update', 'editForm', 'editWin', 'list');">确认</a>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
<%@include file="../master/easyui/footer.jsp" %>

<script>
    function deleteWin(listId) {
        var row = $("#" + listId).datagrid("getSelected");
        if (row) {
            var id = row.bzid;
            $.messager.confirm('删除提示', '您确定要删除选中的记录吗?', function (r) {
                if (r) {
                    $.post('/bz/delete?id=' + id,
                        function (data) {
                            if (data.result == "ok") {
                                showInfoAlert(data.message);
                                $("#" + listId).datagrid("reload");
                            } else {
                                showInfoAlert(data.message);
                            }
                        },
                        "json"
                    );
                }
            });
        } else {
            $.messager.alert('信息提示', '请选择要删除的记录!');
        }
    }

    function openEditWin(winId, listId, formId) {
        var row = $("#" + listId).datagrid("getSelected");
        if (row) {
            $("#" + formId).form("load", row);
            $('#bzname').textbox("setValue", row.bzname);
            $("#state").combobox("select", row.state);
            openWin(winId);
        } else {
            showInfoAlert("请选择需要修改的数据");
        }
    }

</script>

</html>
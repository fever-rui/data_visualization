<%--
  Created by IntelliJ IDEA.
  User: fever
  Date: 2017/4/06
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="am-modal am-modal-alert" tabindex="-1" id="alertSelectFile">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">请先选择文件</div>
        <div class="am-modal-footer">
            <span class="am-modal-btn">确定</span>
        </div>
    </div>
</div>

<div class="am-modal am-modal-no-btn" tabindex="-1" id="success-model">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">Success
            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <div class="am-modal-bd">
            文件导入成功
        </div>
    </div>
</div>


<div class="am-modal am-modal-no-btn" tabindex="-1" id="typeFalse-model">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">Failure
            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <div class="am-modal-hd">
            文件类型错误,请选择txt文件
        </div>
    </div>
</div>

<div class="am-modal am-modal-no-btn" tabindex="-1" id="failure-model">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">Failure
            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <div class="am-modal-hd">
            文件导入失败
        </div>
    </div>
</div>

<div class="am-modal am-modal-no-btn" tabindex="-1" id="downloadFailure-model">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">Failure
            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
        </div>
        <div class="am-modal-hd">
            数据模板下载失败
        </div>
    </div>
</div>
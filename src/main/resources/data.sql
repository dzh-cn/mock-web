insert into mk_project(id, name, role, explaination, created_date)
  values(1, '京小财1', 'jxc', '对私', '2018-6-12 15:12:10');
insert into mk_project(id, name, role, explaination)
  values(2, '京小财2B', 'b2b', '对公');
insert into mk_project(id, name, role, explaination)
  values(3, '征信', 'user', '对公');
insert into mk_facade(id, project_id, uri, name, explaination, method, status, operator, created_date)
  values(1, 1, '/jxc/add', '新增财富', '新增小财财富', 'POST', 'ACTIVE', 'dongzhihua', '2018-6-12 15:12:10');
insert into mk_facade(id, project_id, uri, name, explaination, method, status, operator, created_date)
  values(2, 1, '/jxc/list', '查询财富', '查询小财财富', 'GET', 'ACTIVE', 'dongzhihua', '2018-6-12 15:12:10');
insert into mk_facade(id, project_id, uri, name, explaination, method, status, operator, created_date)
  values(3, 2, '/jxd/list', '查询贷款', '查询小贷贷款', 'GET', 'ACTIVE', 'dongzhihua', '2018-6-12 15:12:10');
insert into mk_param(facade_id, pid, name, explaination, model, type, mock)
  values(1, null, 'sysId', '系统Id', 'REQUEST', 'String', 'mock1');
insert into mk_param(facade_id, pid, name, explaination, model, type, mock)
  values(1, null, 'merId', '商户id', 'REQUEST', 'String', 'mock2');
insert into mk_param(facade_id, pid, name, explaination, model, type, mock)
  values(1, null, 'data', '返回主数据', 'RESPONSE', 'Object', '');
insert into mk_param(facade_id, pid, name, explaination, model, type, mock)
  values(1, null, 'code', '编号', 'RESPONSE', 'Number', '@Number');
insert into mk_param(facade_id, pid, name, explaination, model, type, mock)
  values(1, 3, 'name', '姓名', 'RESPONSE', 'String', '@String');
insert into mk_param(facade_id, pid, name, explaination, model, type, mock)
  values(1, 3, 'orders', '订单列表', 'RESPONSE', 'Array', '@String');
insert into mk_param(facade_id, pid, name, explaination, model, type, mock)
  values(1, null, 'massage', '描述', 'RESPONSE', 'String', '@String');
insert into mk_param(facade_id, pid, name, explaination, model, type, mock)
  values(1, 6, 'id', '订单id', 'RESPONSE', 'String', '@String');
insert into mk_param(facade_id, pid, name, explaination, model, type, mock)
  values(1, 6, 'createdData', '订单日期', 'RESPONSE', 'String', '@String');
insert into mk_param(facade_id, pid, name, explaination, model, type, mock)
  values(1, 6, 'accountNo', '账户编号', 'RESPONSE', 'Boolean', 'mock xy');
insert into mk_param(facade_id, pid, name, explaination, model, type, mock)
  values(1, null, 'data2', '返回主数据2', 'RESPONSE', 'Object', '');
insert into mk_param(facade_id, pid, name, explaination, model, type, mock)
  values(1, null, 'massage1', '描述1', 'RESPONSE', 'String', '@String');
insert into mk_param(facade_id, pid, name, explaination, model, type, mock)
  values(1, null, 'massage2', '描述2', 'RESPONSE', 'String', '@String');
insert into mk_param(facade_id, pid, name, explaination, model, type, mock)
  values(1, 11, 'id', '订单id', 'RESPONSE', 'String', '@String');
insert into mk_param(facade_id, pid, name, explaination, model, type, mock)
  values(1, 11, 'createdData', '订单日期', 'RESPONSE', 'String', '@String');
insert into mk_param(facade_id, pid, name, explaination, model, type, mock)
  values(1, 11, 'accountNo', '账户编号', 'RESPONSE', 'Boolean', 'mock xy');
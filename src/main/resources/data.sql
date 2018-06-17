insert into mk_project(id, name, role, desc, created_date)
  values(1, '京小财1', 'jxc', '对私', '2018-6-12 15:12:10');
insert into mk_project(id, name, role, desc)
  values(2, '京小财2B', 'b2b', '对公');
insert into mk_project(id, name, role, desc)
  values(3, '征信', 'user', '对公');
insert into mk_facade(id, project_id, uri, name, desc, method, status, operator, created_date)
  values(1, 1, '/jxc/add', '新增财富', '新增小财财富', 'POST', 'ACTIVE', 'dongzhihua', '2018-6-12 15:12:10');
insert into mk_facade(id, project_id, uri, name, desc, method, status, operator, created_date)
  values(2, 1, '/jxc/list', '查询财富', '查询小财财富', 'GET', 'ACTIVE', 'dongzhihua', '2018-6-12 15:12:10');
insert into mk_facade(id, project_id, uri, name, desc, method, status, operator, created_date)
  values(3, 2, '/jxd/list', '查询贷款', '查询小贷贷款', 'GET', 'ACTIVE', 'dongzhihua', '2018-6-12 15:12:10');
insert into mk_param(facade_id, fid, name, desc, model, type, mock)
  values(1, null, 'orderId', '订单id', 'REQUEST', 'Array', 'mock1');
insert into mk_param(facade_id, fid, name, desc, model, type, mock)
  values(1, null, 'merId', '商户id', 'REQUEST', 'String', 'mock2');
insert into mk_param(facade_id, fid, name, desc, model, type, mock)
  values(1, null, 'code', '编号', 'RESPONSE', 'Number', '@Number');
insert into mk_param(facade_id, fid, name, desc, model, type, mock)
  values(1, null, 'massage', '描述', 'RESPONSE', 'String', '@String');
insert into mk_param(facade_id, fid, name, desc, model, type, mock)
  values(1, null, 'data', '返回主数据', 'RESPONSE', 'Object', '');
insert into mk_param(facade_id, fid, name, desc, model, type, mock)
  values(1, null, 'name', '姓名', 'RESPONSE', 'String', '@String');
insert into mk_param(facade_id, fid, name, desc, model, type, mock)
  values(2, null, 'accountNo', '账户编号', 'REQUEST', 'Boolean', 'mock xy');
import request from '@/utils/request'

// 查询药物信息列表
export function listDrugInfo(query) {
  return request({
    url: '/manage/drugInfo/list',
    method: 'get',
    params: query
  })
}// 查询药物信息列表
export function listDrugInfoAll(query) {
  return request({
    url: '/manage/drugInfo/listAll',
    method: 'get',
    params: query
  })
}

// 查询药物信息详细
export function getDrugInfo(id) {
  return request({
    url: '/manage/drugInfo/' + id,
    method: 'get'
  })
}

// 新增药物信息
export function addDrugInfo(data) {
  return request({
    url: '/manage/drugInfo',
    method: 'post',
    data: data
  })
}

// 修改药物信息
export function updateDrugInfo(data) {
  return request({
    url: '/manage/drugInfo',
    method: 'put',
    data: data
  })
}

// 删除药物信息
export function delDrugInfo(id) {
  return request({
    url: '/manage/drugInfo/' + id,
    method: 'delete'
  })
}

import request from '@/utils/request'

// 查询症状信息列表
export function listSymptomInfo(query) {
  return request({
    url: '/manage/symptomInfo/list',
    method: 'get',
    params: query
  })
}

// 查询症状信息详细
export function getSymptomInfo(id) {
  return request({
    url: '/manage/symptomInfo/' + id,
    method: 'get'
  })
}

// 新增症状信息
export function addSymptomInfo(data) {
  return request({
    url: '/manage/symptomInfo',
    method: 'post',
    data: data
  })
}

// 修改症状信息
export function updateSymptomInfo(data) {
  return request({
    url: '/manage/symptomInfo',
    method: 'put',
    data: data
  })
}

// 删除症状信息
export function delSymptomInfo(id) {
  return request({
    url: '/manage/symptomInfo/' + id,
    method: 'delete'
  })
}

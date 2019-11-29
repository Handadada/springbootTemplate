一、字典管理
	1.获取字典类型列表 /dictionary/listType
		参数类型: application./json
	  入参: {data : pageSize:15,pageNo:1}
	  出参: response:{

		code: 200,
		msg: '访问成功',
		data: {
			count: 10, //数据总条数
			pages: 2, //数据总页数
			pageNo: 1, //数据起始页
			pageSize: 2, //每页数据量
			list: [
				{
					id: 1,
					code:’ sex’,
					typeDesc: '性别'
				},
				{
					id: 2,
					code: 'classification',
					typeDesc: '消费类型'
				}
			],
		}

	2.获取字典详情列表 /dictionary/listData
		参数类型: application./json
        入参: {data : pageSize:15,
		   		pageNo:1,
		   		typeId:2}
		出参: response:{

		code: 200,
		msg: '访问成功',
		data: {
			count: 10, //数据总条数
			pages: 2, //数据总页数
			pageNo: 1, //数据起始页
			pageSize: 2, //每页数据量
			list: [
				{
					id: 1,
					code: 'classification_01',
					dataDesc: '吃饭餐饮',
					parentId: 0, //就是没有父级的意思
					seq: 0,
					mark:''
				},
				{
					id: 2,
					code: 'classification_02',
					dataDesc: '交通出行',
					parentId: 0,
					seq: 0,
					mark:'无'
				}
			],
		}


	3.添加字典类别 /dictionary/.addType
		参数类型: application./json
		入参: {
				code: 'classification',
				typeDesc: '消费类型'
        }
       出参: {
				code: 200,
				msg: '访问成功'
        }

    4.修改字典类别  /dictionary/.updateType
        参数类型: application./json
            入参: {
                    Id: 1,
                    code: 'classification',
                    typeDesc: '消费类型'
    }
    出参: {
                code: 200,
                msg: '访问成功'
    }

	5.删除字典类别 /dictionary/.deleteType
		参数类型: data
		入参: {
				typeId: 1
    }
    出参: {
                code: 200,
                msg: '访问成功'
    }

	6.添加字典详情	/dictionary/addData
		参数类型: application/json
		入参: {
					typeId: 1,
					code: 'classification_01',
					dataDesc: '吃饭餐饮',
					parentId: 0, //就是没有父级的意思
					seq: 0,
					mark:''
				},
    出参: {
                code: 200,
                msg: '访问成功'
    }

	7.修改字典详情 	/dictionary/updataData
		参数类型: application/json
		入参: {
					id:1,
					typeId: 1,
					code: 'classification_01',
					dataDesc: '吃饭餐饮',
					parentId: 0, //就是没有父级的意思
					seq: 0,
					mark:''
				},
        出参: {
                    code: 200,
                    msg: '访问成功'
        }

	8.删除字典详情 	/dictionary/deleteData
		参数类型: data
		入参: {
				dataId: 1
        }
        出参: {
                    code: 200,
                    msg: '访问成功'
        }

二、账单管理
    1.展示账单列表  /expenseCalendar/list
        参数类型: application./json
        入参: {
            pageSize:15,
            pageNo:1,
            searchDate: 时间日期,
            typeId:2
        }
        出参: response:{

            code: 200,
            msg: '访问成功',
            data: {
                count: 10, //数据总条数
                pages: 2, //数据总页数
                pageNo: 1, //数据起始页
                pageSize: 2, //每页数据量
                list: [
                    {
                        id: 1,
                        typeName:’ 餐饮消费’,
                        money: 125.6,
                        createDate: 日期,
                        createUser: ‘123456’, //创建人员id
                        mark,’备注’
                    },
                    {
                        id: 2,
                        typeName:’ 交通出行’,
                        money: 25.0,
                        createDate: 日期,
                        createUser: ‘123456’, //创建人员id
                        mark,’备注’
                    }
                ],
            }

    2.添加一条账单信息 /expenseCalendar/insert
        application./json
        入参{
            typeName:’ 餐饮消费’,
            money: 125.6,
            createDate: 日期,
            mark,’备注’
        }
        出参: {
            code: 200,
            msg: '访问成功'
        }

    3.修改一条账单信息  /expenseCalendar/update
        application./json
        入参{
            Id: 1,
            typeName:’ 餐饮消费’,
            money: 125.6,
            createDate: 日期,
            mark,’备注’
        }
        出参: {
            code: 200,
            msg: '访问成功'
        }

4.删除一条账单信息 /expenseCalendar/delete
        参数类型: data
        入参: {
            expenseCalendarId: 1
        }
        出参: {
            code: 200,
            msg: '访问成功'
        }


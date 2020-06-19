#!/bin/bash

CONDITION=99

printFunction() {
    echo '<<<<<**********>>>>>'
    echo '1.打包文件'
    echo '2.打包镜像部署'
    echo '3.启动服务'
    echo '4.停止服务'
    echo '5.停止并移除服务'
    echo '6.重启服务'
    echo '0.退出脚本'
    echo '<<<<<**********>>>>>'
    read -p "请输入选项:" CONDITION
}

build() {
    echo '<<<<<**********>>>>>'
    echo '打包中'
    echo '<<<<<**********>>>>>'

    mvn clean package -DskipTests

    echo '<<<<<**********>>>>>'
    echo '打包成功'
    echo '<<<<<**********>>>>>'
}

switchFunction() {
    case $CONDITION in
        0)
            echo '退出脚本'
        ;;
        1)
            build
        ;;
        2)
            docker-compose -f docker-compose-base.yml down && docker-compose -f docker-compose-base.yml build && docker image prune -f && docker-compose -f docker-compose-base.yml up -d
            echo '<<<<<**********>>>>>'
            echo '睡眠5秒，等待基础设施启动完成'
            echo '<<<<<**********>>>>>'
            sleep 5
            docker-compose -f docker-compose-service.yml down && docker-compose -f docker-compose-service.yml build && docker image prune -f &&  docker-compose -f docker-compose-service.yml up -d
        ;;
        3)
            docker-compose -f docker-compose-base.yml start
            docker-compose -f docker-compose-service.yml start
        ;;
        4)
            docker-compose -f docker-compose-service.yml stop
            docker-compose -f docker-compose-base.yml stop
        ;;
        5)
            docker-compose -f docker-compose-service.yml down
            docker-compose -f docker-compose-base.yml down
        ;;
        6)
            docker-compose -f docker-compose-base.yml restart
            docker-compose -f docker-compose-service.yml restart
        ;;
        *)
            echo '错误输入，请重新输入'
        ;;
    esac
}

while [ $CONDITION -ne 0 ]
    do
        printFunction
        switchFunction
    done

echo '<<<<<**********>>>>>'
echo '谢谢使用'
echo '<<<<<**********>>>>>'
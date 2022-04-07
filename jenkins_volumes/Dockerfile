#공식 젠킨스 이미지를 베이스로 한다.
FROM jenkins/jenkins:lts

#root 계정으로 변경(for docker install)
USER root

#젠킨스 컨테이너 내부에서 docker 명령어 사용을 위해 docker 설치
COPY docker_install.sh /docker_install.sh

RUN chmod +x /docker_install.sh

RUN /docker_install.sh

RUN apt-get -y install npm

RUN npm install -g yarn

RUN usermod -aG docker jenkins

USER jenkins
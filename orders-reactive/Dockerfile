FROM alpine:edge
LABEL maintainer="Oscar Andrés Díaz <info@oscarandresdiaz.com>"
RUN apk --update add --no-cache openssh bash \
  && sed -i s/#PermitRootLogin.*/PermitRootLogin\ yes/ /etc/ssh/sshd_config \
  && echo "root:root" | chpasswd \
  && rm -rf /var/cache/apk/*
RUN sed -ie 's/#Port 22/Port 22/g' /etc/ssh/sshd_config
RUN sed -ri 's/#HostKey \/etc\/ssh\/ssh_host_key/HostKey \/etc\/ssh\/ssh_host_key/g' /etc/ssh/sshd_config
RUN sed -ir 's/#HostKey \/etc\/ssh\/ssh_host_rsa_key/HostKey \/etc\/ssh\/ssh_host_rsa_key/g' /etc/ssh/sshd_config
RUN sed -ir 's/#HostKey \/etc\/ssh\/ssh_host_dsa_key/HostKey \/etc\/ssh\/ssh_host_dsa_key/g' /etc/ssh/sshd_config
RUN sed -ir 's/#HostKey \/etc\/ssh\/ssh_host_ecdsa_key/HostKey \/etc\/ssh\/ssh_host_ecdsa_key/g' /etc/ssh/sshd_config
RUN sed -ir 's/#HostKey \/etc\/ssh\/ssh_host_ed25519_key/HostKey \/etc\/ssh\/ssh_host_ed25519_key/g' /etc/ssh/sshd_config
RUN /usr/bin/ssh-keygen -A
RUN ssh-keygen -t rsa -b 4096 -f  /etc/ssh/ssh_host_key
EXPOSE 22

##ADD JAVA
ENV JAVA_HOME="/usr/lib/jvm/default-jvm/"
RUN apk add openjdk11

# Has to be set explictly to find binaries
ENV PATH=$PATH:${JAVA_HOME}/bin

COPY ./orders-reactive/build/libs/orders-reactive-0.0.1-SNAPSHOT.jar /usr/app/

COPY ./ServerAgent-2.2.3 /usr/app/ServerAgent-2.2.3

WORKDIR /usr/app

#enable to run
RUN sh -c 'touch orders-reactive-0.0.1-SNAPSHOT.jar'

##ADD systats to alpine
RUN apk add sysstat

CMD ["sh","-c", "/usr/sbin/sshd -D & java -jar orders-reactive-0.0.1-SNAPSHOT.jar & ./ServerAgent-2.2.3/startAgent.sh"]

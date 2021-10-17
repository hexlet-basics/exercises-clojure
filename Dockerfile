FROM hexletbasics/base-image:latest

RUN curl -O https://download.clojure.org/install/linux-install-1.10.3.986.sh && \
    chmod +x linux-install-1.10.3.986.sh && \
    sudo ./linux-install-1.10.3.986.sh

WORKDIR /exercises-clojure

COPY . .
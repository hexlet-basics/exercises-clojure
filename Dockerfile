FROM hexletbasics/base-image:latest

RUN curl -O https://download.clojure.org/install/linux-install-1.11.1.1208.sh && \
    chmod +x linux-install-1.11.1.1208.sh && \
    ./linux-install-1.11.1.1208.sh

RUN apt-get update && apt-get install -y openjdk-17-jdk rlwrap

RUN curl -sLO https://raw.githubusercontent.com/babashka/babashka/master/install && \
    chmod +x install && ./install --version 1.3.185

WORKDIR /exercises-clojure

COPY . .

ENV PATH=/exercises-clojure/bin:$PATH

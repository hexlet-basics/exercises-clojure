FROM hexletbasics/base-image:latest

RUN curl -O https://download.clojure.org/install/linux-install-1.10.3.986.sh && \
    chmod +x linux-install-1.10.3.986.sh && \
    ./linux-install-1.10.3.986.sh

RUN apt-get update && apt-get install -y openjdk-16-jdk rlwrap

RUN curl -sLO https://raw.githubusercontent.com/babashka/babashka/master/install && \
    chmod +x install && ./install

WORKDIR /exercises-clojure

COPY . .

ENV PATH=/exercises-clojure/bin:$PATH

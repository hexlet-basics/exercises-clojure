FROM hexletbasics/base-image:latest

RUN curl -O https://download.clojure.org/install/linux-install-1.10.3.986.sh && \
    chmod +x linux-install-1.10.3.986.sh && \
    ./linux-install-1.10.3.986.sh

RUN apt-get update && apt-get install -y default-jdk rlwrap

WORKDIR /exercises-clojure

COPY . .

# FIXME: При первом запуске тестов clojure скачивает необходимые зависимости.
# ВОзможно не самая лучшая команда для этого
RUN clj -X:deps prep

ENV PATH=/exercises-clojure/bin:$PATH

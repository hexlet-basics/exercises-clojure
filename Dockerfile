FROM eclipse-temurin:25-jdk AS java

FROM hexletbasics/base-image:latest

COPY --from=java /opt/java/openjdk /opt/java/openjdk
ENV JAVA_HOME=/opt/java/openjdk
ENV PATH="/opt/java/openjdk/bin:/exercises-clojure/bin:$PATH"

RUN apt-get update && apt-get install -y --no-install-recommends rlwrap \
    && rm -rf /var/lib/apt/lists/*

ARG CLOJURE_VERSION=1.12.6.1673
ARG BABASHKA_VERSION=1.13.229
RUN curl -fsSL "https://download.clojure.org/install/linux-install-${CLOJURE_VERSION}.sh" -o /tmp/clojure-install.sh \
    && bash /tmp/clojure-install.sh \
    && rm -f /tmp/clojure-install.sh \
    && curl -fsSL "https://raw.githubusercontent.com/babashka/babashka/v${BABASHKA_VERSION}/install" -o /tmp/babashka-install \
    && bash /tmp/babashka-install --version "${BABASHKA_VERSION}" \
    && rm -f /tmp/babashka-install

WORKDIR /exercises-clojure

COPY . .

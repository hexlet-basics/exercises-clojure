FROM hexletbasics/base-image:latest

ENV PATH="/exercises-clojure/bin:$PATH"

RUN apt-get update && apt-get install -y --no-install-recommends \
    openjdk-21-jdk \
    rlwrap \
    && rm -rf /var/lib/apt/lists/*

RUN curl -fsSL https://download.clojure.org/install/linux-install-1.12.0.1530.sh -o /tmp/clojure-install.sh && \
    chmod +x /tmp/clojure-install.sh && \
    /tmp/clojure-install.sh && \
    rm -f /tmp/clojure-install.sh && \
    curl -fsSL https://raw.githubusercontent.com/babashka/babashka/master/install -o /tmp/babashka-install && \
    chmod +x /tmp/babashka-install && \
    /tmp/babashka-install --version 1.3.185 && \
    rm -f /tmp/babashka-install

WORKDIR /exercises-clojure

COPY . .

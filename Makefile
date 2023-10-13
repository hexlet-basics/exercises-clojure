-include /opt/basics/common/common.mk

compose-setup: compose-build

compose:
	docker-compose up

compose-build:
	docker-compose build

code-lint:
	clj -Sdeps '{:deps {dev.weavejester/cljfmt {:mvn/version "0.11.2"}}}' -M -m cljfmt.main check modules src

code-format:
	clj -Sdeps '{:deps {dev.weavejester/cljfmt {:mvn/version "0.11.2"}}}' -M -m cljfmt.main fix modules src

compose-bash:
	docker-compose run exercises bash

compose-test:
	docker-compose run exercises make test

ci-check:
	docker-compose --file docker-compose.yml up --abort-on-container-exit

-include /opt/basics/common/common.mk

compose-setup: compose-build

compose:
	docker-compose up

compose-build:
	docker-compose build

code-lint:
	clj -Sdeps '{:deps {cljfmt {:mvn/version "0.8.0"}}}' -m cljfmt.main check modules

compose-bash:
	docker-compose run exercises bash

compose-test:
	docker-compose run exercises make test

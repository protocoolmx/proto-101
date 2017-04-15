# docker-entry-test

This is a simple [Docker](https://docs.docker.com/engine/) example of how to use [ENTRYPOINT](https://docs.docker.com/engine/reference/builder/#entrypoint) along with [CMD](https://docs.docker.com/engine/reference/builder/#cmd).

## Build

```sh
$ docker build . --tag=entry_test:dev
```

## Running

Default parameters (CMD).

```sh
$ docker run --rm entry_test:dev

# Expected output ::
#
# Hello from entrypoint_01!
# Hello from entrypoint_02!
# Hello from inside!
```

Override default parameters (CMD).

```sh
$ docker run --rm entry_test:dev echo "Hello from outside\!"

# Expected output ::
#
# Hello from entrypoint_01!
# Hello from entrypoint_02!
# Hello from outside!
```

## References

*   [Docker ENTRYPOINT Best Practices](https://docs.docker.com/engine/userguide/eng-image/dockerfile_best-practices/#entrypoint)

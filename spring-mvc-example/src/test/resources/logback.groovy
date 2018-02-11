import ch.qos.logback.classic.encoder.PatternLayoutEncoder

appender("STDOUT", ConsoleAppender) {
    append = true
    encoder(PatternLayoutEncoder) {
        pattern = "%d [%thread] %level %logger - %m%n"
    }
}

root(INFO, ["STDOUT"])
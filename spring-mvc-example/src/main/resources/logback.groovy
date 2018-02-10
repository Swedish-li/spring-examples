
appender("STDOUT", ConsoleAppender) {
    append = true
    encoder(PatternLayoutEncoder) {
        pattern = "%d [%thread] %level %logger - %m%n"
    }
}

root(DEBUG, ["STDOUT"])
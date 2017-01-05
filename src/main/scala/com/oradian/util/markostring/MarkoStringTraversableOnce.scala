package com.oradian.util.markostring

class MarkoStringTraversableOnce[T](val values: TraversableOnce[T]) extends AnyVal {
  def markoString(start: String, sep: String, lastSep: String, last: String): String = {
    val sb = new java.lang.StringBuilder

    var lastStringValue = ""
    var separator = ""

    sb append start
    for (value <- values) {
      sb append lastStringValue append separator
      lastStringValue = String.valueOf(value)
      separator = sep
    }

    if (sb.length > start.length) {
      sb.setLength(sb.length - sep.length)
      sb append lastSep
    }

    sb append lastStringValue append last toString
  }
}

trait MarkoStringTraversableOncePimp {
  implicit def toMarkoStringTraversableOnce[T](values: TraversableOnce[T]): MarkoStringTraversableOnce[T] =
    new MarkoStringTraversableOnce(values)
}

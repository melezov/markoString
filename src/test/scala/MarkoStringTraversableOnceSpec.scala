package com.oradian.util.markostring

import org.specs2._

class MarkoStringTraversableOnceSpec extends Specification with ScalaCheck {
  private[this] def reference[T](to: TraversableOnce[T], start: String, sep: String, lastSep: String, last: String): String = {
    val seq = to.toIndexedSeq

    seq.length match {
      case 0 =>
        start + last
      case 1 =>
        start + seq.head + last
      case 2 =>
        start + seq.head + lastSep + seq.last + last
      case x =>
        start + seq.head + seq.tail.init.mkString(sep, sep, lastSep) + seq.last + last
    }
  }

  def randomTest = prop { (to: List[String], start: String, sep: String, lastSep: String, last: String) =>
    to.markoString(start, sep, lastSep, last) ==== reference(to, start, sep, lastSep, last)
  }

    def is = s2"""
      Random test  $randomTest
"""
}

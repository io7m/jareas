/*
 * Copyright © 2015 <code@io7m.com> http://io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.jareas.core;

import com.io7m.jranges.RangeInclusiveD;
import org.immutables.value.Value;

import java.util.Objects;

/**
 * The type of inclusive areas with {@code double} components.
 */

@Value.Immutable public interface AreaInclusiveDType
{
  /**
   * @return The inclusive range of values on the {@code X} axis
   */

  @Value.Parameter(order = 0) RangeInclusiveD getRangeX();

  /**
   * @return The inclusive range of values on the {@code Y} axis
   */

  @Value.Parameter(order = 1) RangeInclusiveD getRangeY();

  /**
   * @param other The including area
   *
   * @return {@code true} if this area is included within the given area.
   */

  default boolean isIncludedIn(
    final AreaInclusiveDType other)
  {
    Objects.requireNonNull(other, "Other");
    // CHECKSTYLE:OFF
    final RangeInclusiveD rx = this.getRangeX();
    final RangeInclusiveD ry = this.getRangeY();
    final RangeInclusiveD o_rx = other.getRangeX();
    final RangeInclusiveD o_ry = other.getRangeY();
    // CHECKSTYLE:ON
    return rx.isIncludedIn(o_rx) && ry.isIncludedIn(o_ry);
  }
}

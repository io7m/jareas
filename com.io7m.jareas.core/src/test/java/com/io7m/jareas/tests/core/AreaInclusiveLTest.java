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

package com.io7m.jareas.tests.core;

import com.io7m.jareas.core.AreaInclusiveL;
import com.io7m.jareas.core.AreaInclusiveLType;
import com.io7m.jranges.RangeInclusiveL;
import org.junit.Assert;
import org.junit.Test;

public final class AreaInclusiveLTest
{
  @Test public void testAreaWithX()
  {
    final RangeInclusiveL r0 = new RangeInclusiveL(0L, 99L);
    final RangeInclusiveL r1 = new RangeInclusiveL(100L, 199L);

    final AreaInclusiveL a0 = AreaInclusiveL.of(r0, r0);
    Assert.assertEquals(r1, a0.withRangeX(r1).getRangeX());
  }

  @Test public void testAreaWithY()
  {
    final RangeInclusiveL r0 = new RangeInclusiveL(0L, 99L);
    final RangeInclusiveL r1 = new RangeInclusiveL(100L, 199L);

    final AreaInclusiveL a0 = AreaInclusiveL.of(r0, r0);
    Assert.assertEquals(r1, a0.withRangeY(r1).getRangeY());
  }

  @Test public void testAreaCopyOf()
  {
    final RangeInclusiveL r0 = new RangeInclusiveL(0L, 99L);
    final AreaInclusiveL a0 = AreaInclusiveL.of(r0, r0);

    {
      final AreaInclusiveL a1 = AreaInclusiveL.copyOf(a0);
      Assert.assertEquals(a0, a1);
    }

    {
      final AreaInclusiveL a1 = AreaInclusiveL.copyOf(
        new AreaInclusiveLType()
        {
          @Override public RangeInclusiveL getRangeX()
          {
            return r0;
          }

          @Override public RangeInclusiveL getRangeY()
          {
            return r0;
          }
        });
      Assert.assertEquals(a0, a1);
    }
  }

  @Test public void testAreaEquals()
  {
    final RangeInclusiveL r0 = new RangeInclusiveL(0L, 99L);
    final RangeInclusiveL r1 = new RangeInclusiveL(0L, 99L);
    final RangeInclusiveL r2 = new RangeInclusiveL(0L, 98L);
    final RangeInclusiveL r3 = new RangeInclusiveL(1L, 99L);

    final AreaInclusiveL a0 = AreaInclusiveL.of(r0, r0);
    final AreaInclusiveL a1 = AreaInclusiveL.of(r1, r1);
    final AreaInclusiveL a2 = AreaInclusiveL.of(r0, r2);
    final AreaInclusiveL a3 = AreaInclusiveL.of(r0, r3);
    final AreaInclusiveL a4 = AreaInclusiveL.of(r2, r0);
    final AreaInclusiveL a5 = AreaInclusiveL.of(r3, r0);

    Assert.assertEquals(a0, a0);
    Assert.assertEquals(a0, a1);
    Assert.assertEquals(a1, a0);

    Assert.assertNotEquals(a0, a2);
    Assert.assertNotEquals(a0, a3);
    Assert.assertNotEquals(a0, a4);
    Assert.assertNotEquals(a0, a5);

    Assert.assertNotEquals(a0, null);
    Assert.assertNotEquals(a0, Integer.valueOf(32));
  }

  @Test public void testAreaHashcode()
  {
    final RangeInclusiveL r0 = new RangeInclusiveL(0L, 99L);
    final RangeInclusiveL r1 = new RangeInclusiveL(0L, 99L);
    final RangeInclusiveL r2 = new RangeInclusiveL(0L, 98L);
    final RangeInclusiveL r3 = new RangeInclusiveL(1L, 99L);

    final AreaInclusiveL a0 = AreaInclusiveL.of(r0, r0);
    final AreaInclusiveL a1 = AreaInclusiveL.of(r1, r1);
    final AreaInclusiveL a2 = AreaInclusiveL.of(r0, r2);
    final AreaInclusiveL a3 = AreaInclusiveL.of(r0, r3);
    final AreaInclusiveL a4 = AreaInclusiveL.of(r2, r0);
    final AreaInclusiveL a5 = AreaInclusiveL.of(r3, r0);

    Assert.assertEquals((long) a0.hashCode(), (long) a0.hashCode());
    Assert.assertEquals((long) a0.hashCode(), (long) a1.hashCode());

    Assert.assertNotEquals((long) a0.hashCode(), (long) a2.hashCode());
    Assert.assertNotEquals((long) a0.hashCode(), (long) a3.hashCode());
    Assert.assertNotEquals((long) a0.hashCode(), (long) a4.hashCode());
    Assert.assertNotEquals((long) a0.hashCode(), (long) a5.hashCode());
  }

  @Test public void testAreaToString()
  {
    final RangeInclusiveL r0 = new RangeInclusiveL(0L, 99L);
    final RangeInclusiveL r1 = new RangeInclusiveL(0L, 99L);
    final RangeInclusiveL r2 = new RangeInclusiveL(0L, 98L);
    final RangeInclusiveL r3 = new RangeInclusiveL(1L, 99L);

    final AreaInclusiveL a0 = AreaInclusiveL.of(r0, r0);
    final AreaInclusiveL a1 = AreaInclusiveL.of(r1, r1);
    final AreaInclusiveL a2 = AreaInclusiveL.of(r0, r2);
    final AreaInclusiveL a3 = AreaInclusiveL.of(r0, r3);
    final AreaInclusiveL a4 = AreaInclusiveL.of(r2, r0);
    final AreaInclusiveL a5 = AreaInclusiveL.of(r3, r0);

    Assert.assertEquals(a0.toString(), a0.toString());
    Assert.assertEquals(a0.toString(), a1.toString());
    Assert.assertEquals(a1.toString(), a0.toString());

    Assert.assertNotEquals(a0.toString(), a2.toString());
    Assert.assertNotEquals(a0.toString(), a3.toString());
    Assert.assertNotEquals(a0.toString(), a4.toString());
    Assert.assertNotEquals(a0.toString(), a5.toString());
  }
}

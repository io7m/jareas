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

import com.io7m.jareas.core.AreaInclusiveI;
import com.io7m.jareas.core.AreaInclusiveIType;
import com.io7m.jranges.RangeInclusiveI;
import org.junit.Assert;
import org.junit.Test;

public final class AreaInclusiveITest
{
  @Test public void testAreaWithX()
  {
    final RangeInclusiveI r0 = new RangeInclusiveI(0, 99);
    final RangeInclusiveI r1 = new RangeInclusiveI(100, 199);

    final AreaInclusiveI a0 = AreaInclusiveI.of(r0, r0);
    Assert.assertEquals(r1, a0.withRangeX(r1).getRangeX());
  }

  @Test public void testAreaWithY()
  {
    final RangeInclusiveI r0 = new RangeInclusiveI(0, 99);
    final RangeInclusiveI r1 = new RangeInclusiveI(100, 199);

    final AreaInclusiveI a0 = AreaInclusiveI.of(r0, r0);
    Assert.assertEquals(r1, a0.withRangeY(r1).getRangeY());
  }

  @Test public void testAreaCopyOf()
  {
    final RangeInclusiveI r0 = new RangeInclusiveI(0, 99);
    final AreaInclusiveI a0 = AreaInclusiveI.of(r0, r0);

    {
      final AreaInclusiveI a1 = AreaInclusiveI.copyOf(a0);
      Assert.assertEquals(a0, a1);
    }

    {
      final AreaInclusiveI a1 = AreaInclusiveI.copyOf(
        new AreaInclusiveIType()
        {
          @Override public RangeInclusiveI getRangeX()
          {
            return r0;
          }

          @Override public RangeInclusiveI getRangeY()
          {
            return r0;
          }
        });
      Assert.assertEquals(a0, a1);
    }
  }

  @Test public void testAreaEquals()
  {
    final RangeInclusiveI r0 = new RangeInclusiveI(0, 99);
    final RangeInclusiveI r1 = new RangeInclusiveI(0, 99);
    final RangeInclusiveI r2 = new RangeInclusiveI(0, 98);
    final RangeInclusiveI r3 = new RangeInclusiveI(1, 99);

    final AreaInclusiveI a0 = AreaInclusiveI.of(r0, r0);
    final AreaInclusiveI a1 = AreaInclusiveI.of(r1, r1);
    final AreaInclusiveI a2 = AreaInclusiveI.of(r0, r2);
    final AreaInclusiveI a3 = AreaInclusiveI.of(r0, r3);
    final AreaInclusiveI a4 = AreaInclusiveI.of(r2, r0);
    final AreaInclusiveI a5 = AreaInclusiveI.of(r3, r0);

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
    final RangeInclusiveI r0 = new RangeInclusiveI(0, 99);
    final RangeInclusiveI r1 = new RangeInclusiveI(0, 99);
    final RangeInclusiveI r2 = new RangeInclusiveI(0, 98);
    final RangeInclusiveI r3 = new RangeInclusiveI(1, 99);

    final AreaInclusiveI a0 = AreaInclusiveI.of(r0, r0);
    final AreaInclusiveI a1 = AreaInclusiveI.of(r1, r1);
    final AreaInclusiveI a2 = AreaInclusiveI.of(r0, r2);
    final AreaInclusiveI a3 = AreaInclusiveI.of(r0, r3);
    final AreaInclusiveI a4 = AreaInclusiveI.of(r2, r0);
    final AreaInclusiveI a5 = AreaInclusiveI.of(r3, r0);

    Assert.assertEquals((long) a0.hashCode(), (long) a0.hashCode());
    Assert.assertEquals((long) a0.hashCode(), (long) a1.hashCode());

    Assert.assertNotEquals((long) a0.hashCode(), (long) a2.hashCode());
    Assert.assertNotEquals((long) a0.hashCode(), (long) a3.hashCode());
    Assert.assertNotEquals((long) a0.hashCode(), (long) a4.hashCode());
    Assert.assertNotEquals((long) a0.hashCode(), (long) a5.hashCode());
  }

  @Test public void testAreaToString()
  {
    final RangeInclusiveI r0 = new RangeInclusiveI(0, 99);
    final RangeInclusiveI r1 = new RangeInclusiveI(0, 99);
    final RangeInclusiveI r2 = new RangeInclusiveI(0, 98);
    final RangeInclusiveI r3 = new RangeInclusiveI(1, 99);

    final AreaInclusiveI a0 = AreaInclusiveI.of(r0, r0);
    final AreaInclusiveI a1 = AreaInclusiveI.of(r1, r1);
    final AreaInclusiveI a2 = AreaInclusiveI.of(r0, r2);
    final AreaInclusiveI a3 = AreaInclusiveI.of(r0, r3);
    final AreaInclusiveI a4 = AreaInclusiveI.of(r2, r0);
    final AreaInclusiveI a5 = AreaInclusiveI.of(r3, r0);

    Assert.assertEquals(a0.toString(), a0.toString());
    Assert.assertEquals(a0.toString(), a1.toString());
    Assert.assertEquals(a1.toString(), a0.toString());

    Assert.assertNotEquals(a0.toString(), a2.toString());
    Assert.assertNotEquals(a0.toString(), a3.toString());
    Assert.assertNotEquals(a0.toString(), a4.toString());
    Assert.assertNotEquals(a0.toString(), a5.toString());
  }
}

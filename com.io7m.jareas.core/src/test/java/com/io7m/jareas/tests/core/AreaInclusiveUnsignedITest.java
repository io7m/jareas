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

import com.io7m.jareas.core.AreaInclusiveUnsignedI;
import com.io7m.jareas.core.AreaInclusiveUnsignedIType;
import com.io7m.junsigned.ranges.UnsignedRangeInclusiveI;
import org.junit.Assert;
import org.junit.Test;

public final class AreaInclusiveUnsignedITest
{
  @Test public void testAreaWithX()
  {
    final UnsignedRangeInclusiveI r0 = new UnsignedRangeInclusiveI(0, 99);
    final UnsignedRangeInclusiveI r1 = new UnsignedRangeInclusiveI(100, 199);

    final AreaInclusiveUnsignedI a0 = AreaInclusiveUnsignedI.of(r0, r0);
    Assert.assertEquals(r1, a0.withRangeX(r1).getRangeX());
  }

  @Test public void testAreaWithY()
  {
    final UnsignedRangeInclusiveI r0 = new UnsignedRangeInclusiveI(0, 99);
    final UnsignedRangeInclusiveI r1 = new UnsignedRangeInclusiveI(100, 199);

    final AreaInclusiveUnsignedI a0 = AreaInclusiveUnsignedI.of(r0, r0);
    Assert.assertEquals(r1, a0.withRangeY(r1).getRangeY());
  }

  @Test public void testAreaCopyOf()
  {
    final UnsignedRangeInclusiveI r0 = new UnsignedRangeInclusiveI(0, 99);
    final AreaInclusiveUnsignedI a0 = AreaInclusiveUnsignedI.of(r0, r0);

    {
      final AreaInclusiveUnsignedI a1 = AreaInclusiveUnsignedI.copyOf(a0);
      Assert.assertEquals(a0, a1);
    }

    {
      final AreaInclusiveUnsignedI a1 = AreaInclusiveUnsignedI.copyOf(
        new AreaInclusiveUnsignedIType()
        {
          @Override public UnsignedRangeInclusiveI getRangeX()
          {
            return r0;
          }

          @Override public UnsignedRangeInclusiveI getRangeY()
          {
            return r0;
          }
        });
      Assert.assertEquals(a0, a1);
    }
  }

  @Test public void testAreaEquals()
  {
    final UnsignedRangeInclusiveI r0 = new UnsignedRangeInclusiveI(0, 99);
    final UnsignedRangeInclusiveI r1 = new UnsignedRangeInclusiveI(0, 99);
    final UnsignedRangeInclusiveI r2 = new UnsignedRangeInclusiveI(0, 98);
    final UnsignedRangeInclusiveI r3 = new UnsignedRangeInclusiveI(1, 99);

    final AreaInclusiveUnsignedI a0 = AreaInclusiveUnsignedI.of(r0, r0);
    final AreaInclusiveUnsignedI a1 = AreaInclusiveUnsignedI.of(r1, r1);
    final AreaInclusiveUnsignedI a2 = AreaInclusiveUnsignedI.of(r0, r2);
    final AreaInclusiveUnsignedI a3 = AreaInclusiveUnsignedI.of(r0, r3);
    final AreaInclusiveUnsignedI a4 = AreaInclusiveUnsignedI.of(r2, r0);
    final AreaInclusiveUnsignedI a5 = AreaInclusiveUnsignedI.of(r3, r0);

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
    final UnsignedRangeInclusiveI r0 = new UnsignedRangeInclusiveI(0, 99);
    final UnsignedRangeInclusiveI r1 = new UnsignedRangeInclusiveI(0, 99);
    final UnsignedRangeInclusiveI r2 = new UnsignedRangeInclusiveI(0, 98);
    final UnsignedRangeInclusiveI r3 = new UnsignedRangeInclusiveI(1, 99);

    final AreaInclusiveUnsignedI a0 = AreaInclusiveUnsignedI.of(r0, r0);
    final AreaInclusiveUnsignedI a1 = AreaInclusiveUnsignedI.of(r1, r1);
    final AreaInclusiveUnsignedI a2 = AreaInclusiveUnsignedI.of(r0, r2);
    final AreaInclusiveUnsignedI a3 = AreaInclusiveUnsignedI.of(r0, r3);
    final AreaInclusiveUnsignedI a4 = AreaInclusiveUnsignedI.of(r2, r0);
    final AreaInclusiveUnsignedI a5 = AreaInclusiveUnsignedI.of(r3, r0);

    Assert.assertEquals((long) a0.hashCode(), (long) a0.hashCode());
    Assert.assertEquals((long) a0.hashCode(), (long) a1.hashCode());

    Assert.assertNotEquals((long) a0.hashCode(), (long) a2.hashCode());
    Assert.assertNotEquals((long) a0.hashCode(), (long) a3.hashCode());
    Assert.assertNotEquals((long) a0.hashCode(), (long) a4.hashCode());
    Assert.assertNotEquals((long) a0.hashCode(), (long) a5.hashCode());
  }

  @Test public void testAreaToString()
  {
    final UnsignedRangeInclusiveI r0 = new UnsignedRangeInclusiveI(0, 99);
    final UnsignedRangeInclusiveI r1 = new UnsignedRangeInclusiveI(0, 99);
    final UnsignedRangeInclusiveI r2 = new UnsignedRangeInclusiveI(0, 98);
    final UnsignedRangeInclusiveI r3 = new UnsignedRangeInclusiveI(1, 99);

    final AreaInclusiveUnsignedI a0 = AreaInclusiveUnsignedI.of(r0, r0);
    final AreaInclusiveUnsignedI a1 = AreaInclusiveUnsignedI.of(r1, r1);
    final AreaInclusiveUnsignedI a2 = AreaInclusiveUnsignedI.of(r0, r2);
    final AreaInclusiveUnsignedI a3 = AreaInclusiveUnsignedI.of(r0, r3);
    final AreaInclusiveUnsignedI a4 = AreaInclusiveUnsignedI.of(r2, r0);
    final AreaInclusiveUnsignedI a5 = AreaInclusiveUnsignedI.of(r3, r0);

    Assert.assertEquals(a0.toString(), a0.toString());
    Assert.assertEquals(a0.toString(), a1.toString());
    Assert.assertEquals(a1.toString(), a0.toString());

    Assert.assertNotEquals(a0.toString(), a2.toString());
    Assert.assertNotEquals(a0.toString(), a3.toString());
    Assert.assertNotEquals(a0.toString(), a4.toString());
    Assert.assertNotEquals(a0.toString(), a5.toString());
  }
}

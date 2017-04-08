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

import com.io7m.jareas.core.AreaInclusiveB;
import com.io7m.jareas.core.AreaInclusiveBType;
import com.io7m.jranges.RangeInclusiveB;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public final class AreaInclusiveBTest
{
  @Test public void testAreaWithX()
  {
    final RangeInclusiveB r0 = new RangeInclusiveB(BigInteger.valueOf(0L), BigInteger.valueOf(99L));
    final RangeInclusiveB r1 = new RangeInclusiveB(BigInteger.valueOf(100L), BigInteger.valueOf(199L));

    final AreaInclusiveB a0 = AreaInclusiveB.of(r0, r0);
    Assert.assertEquals(r1, a0.withRangeX(r1).getRangeX());
  }

  @Test public void testAreaWithY()
  {
    final RangeInclusiveB r0 = new RangeInclusiveB(BigInteger.valueOf(0L), BigInteger.valueOf(99L));
    final RangeInclusiveB r1 = new RangeInclusiveB(BigInteger.valueOf(100L), BigInteger.valueOf(199L));

    final AreaInclusiveB a0 = AreaInclusiveB.of(r0, r0);
    Assert.assertEquals(r1, a0.withRangeY(r1).getRangeY());
  }

  @Test public void testAreaCopyOf()
  {
    final RangeInclusiveB r0 = new RangeInclusiveB(BigInteger.valueOf(0L), BigInteger.valueOf(99L));
    final AreaInclusiveB a0 = AreaInclusiveB.of(r0, r0);

    {
      final AreaInclusiveB a1 = AreaInclusiveB.copyOf(a0);
      Assert.assertEquals(a0, a1);
    }

    {
      final AreaInclusiveB a1 = AreaInclusiveB.copyOf(
        new AreaInclusiveBType()
        {
          @Override public RangeInclusiveB getRangeX()
          {
            return r0;
          }

          @Override public RangeInclusiveB getRangeY()
          {
            return r0;
          }
        });
      Assert.assertEquals(a0, a1);
    }
  }

  @Test public void testAreaEquals()
  {
    final RangeInclusiveB r0 = new RangeInclusiveB(BigInteger.valueOf(0L), BigInteger.valueOf(99L));
    final RangeInclusiveB r1 = new RangeInclusiveB(BigInteger.valueOf(0L), BigInteger.valueOf(99L));
    final RangeInclusiveB r2 = new RangeInclusiveB(BigInteger.valueOf(0L), BigInteger.valueOf(98L));
    final RangeInclusiveB r3 = new RangeInclusiveB(BigInteger.valueOf(1L), BigInteger.valueOf(99L));

    final AreaInclusiveB a0 = AreaInclusiveB.of(r0, r0);
    final AreaInclusiveB a1 = AreaInclusiveB.of(r1, r1);
    final AreaInclusiveB a2 = AreaInclusiveB.of(r0, r2);
    final AreaInclusiveB a3 = AreaInclusiveB.of(r0, r3);
    final AreaInclusiveB a4 = AreaInclusiveB.of(r2, r0);
    final AreaInclusiveB a5 = AreaInclusiveB.of(r3, r0);

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
    final RangeInclusiveB r0 = new RangeInclusiveB(BigInteger.valueOf(0L), BigInteger.valueOf(99L));
    final RangeInclusiveB r1 = new RangeInclusiveB(BigInteger.valueOf(0L), BigInteger.valueOf(99L));
    final RangeInclusiveB r2 = new RangeInclusiveB(BigInteger.valueOf(0L), BigInteger.valueOf(98L));
    final RangeInclusiveB r3 = new RangeInclusiveB(BigInteger.valueOf(1L), BigInteger.valueOf(99L));

    final AreaInclusiveB a0 = AreaInclusiveB.of(r0, r0);
    final AreaInclusiveB a1 = AreaInclusiveB.of(r1, r1);
    final AreaInclusiveB a2 = AreaInclusiveB.of(r0, r2);
    final AreaInclusiveB a3 = AreaInclusiveB.of(r0, r3);
    final AreaInclusiveB a4 = AreaInclusiveB.of(r2, r0);
    final AreaInclusiveB a5 = AreaInclusiveB.of(r3, r0);

    Assert.assertEquals((long) a0.hashCode(), (long) a0.hashCode());
    Assert.assertEquals((long) a0.hashCode(), (long) a1.hashCode());

    Assert.assertNotEquals((long) a0.hashCode(), (long) a2.hashCode());
    Assert.assertNotEquals((long) a0.hashCode(), (long) a3.hashCode());
    Assert.assertNotEquals((long) a0.hashCode(), (long) a4.hashCode());
    Assert.assertNotEquals((long) a0.hashCode(), (long) a5.hashCode());
  }

  @Test public void testAreaToString()
  {
    final RangeInclusiveB r0 = new RangeInclusiveB(BigInteger.valueOf(0L), BigInteger.valueOf(99L));
    final RangeInclusiveB r1 = new RangeInclusiveB(BigInteger.valueOf(0L), BigInteger.valueOf(99L));
    final RangeInclusiveB r2 = new RangeInclusiveB(BigInteger.valueOf(0L), BigInteger.valueOf(98L));
    final RangeInclusiveB r3 = new RangeInclusiveB(BigInteger.valueOf(1L), BigInteger.valueOf(99L));

    final AreaInclusiveB a0 = AreaInclusiveB.of(r0, r0);
    final AreaInclusiveB a1 = AreaInclusiveB.of(r1, r1);
    final AreaInclusiveB a2 = AreaInclusiveB.of(r0, r2);
    final AreaInclusiveB a3 = AreaInclusiveB.of(r0, r3);
    final AreaInclusiveB a4 = AreaInclusiveB.of(r2, r0);
    final AreaInclusiveB a5 = AreaInclusiveB.of(r3, r0);

    Assert.assertEquals(a0.toString(), a0.toString());
    Assert.assertEquals(a0.toString(), a1.toString());
    Assert.assertEquals(a1.toString(), a0.toString());

    Assert.assertNotEquals(a0.toString(), a2.toString());
    Assert.assertNotEquals(a0.toString(), a3.toString());
    Assert.assertNotEquals(a0.toString(), a4.toString());
    Assert.assertNotEquals(a0.toString(), a5.toString());
  }
}

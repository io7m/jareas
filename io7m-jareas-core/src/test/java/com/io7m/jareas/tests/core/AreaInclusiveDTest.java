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

import com.io7m.jareas.core.AreaInclusiveD;
import com.io7m.jareas.core.AreaInclusiveDType;
import com.io7m.jranges.RangeInclusiveD;
import org.junit.Assert;
import org.junit.Test;

public final class AreaInclusiveDTest
{
  @Test public void testAreaWithX()
  {
    final RangeInclusiveD r0 = new RangeInclusiveD(0.0, 99.0);
    final RangeInclusiveD r1 = new RangeInclusiveD(100.0, 199.0);

    final AreaInclusiveD a0 = AreaInclusiveD.of(r0, r0);
    Assert.assertEquals(r1, a0.withRangeX(r1).getRangeX());
  }

  @Test public void testAreaWithY()
  {
    final RangeInclusiveD r0 = new RangeInclusiveD(0.0, 99.0);
    final RangeInclusiveD r1 = new RangeInclusiveD(100.0, 199.0);

    final AreaInclusiveD a0 = AreaInclusiveD.of(r0, r0);
    Assert.assertEquals(r1, a0.withRangeY(r1).getRangeY());
  }

  @Test public void testAreaCopyOf()
  {
    final RangeInclusiveD r0 = new RangeInclusiveD(0.0, 99.0);
    final AreaInclusiveD a0 = AreaInclusiveD.of(r0, r0);

    {
      final AreaInclusiveD a1 = AreaInclusiveD.copyOf(a0);
      Assert.assertEquals(a0, a1);
    }

    {
      final AreaInclusiveD a1 = AreaInclusiveD.copyOf(
        new AreaInclusiveDType()
        {
          @Override public RangeInclusiveD getRangeX()
          {
            return r0;
          }

          @Override public RangeInclusiveD getRangeY()
          {
            return r0;
          }
        });
      Assert.assertEquals(a0, a1);
    }
  }

  @Test public void testAreaEquals()
  {
    final RangeInclusiveD r0 = new RangeInclusiveD(0.0, 99.0);
    final RangeInclusiveD r1 = new RangeInclusiveD(0.0, 99.0);
    final RangeInclusiveD r2 = new RangeInclusiveD(0.0, 98.0);
    final RangeInclusiveD r3 = new RangeInclusiveD(1.0, 99.0);

    final AreaInclusiveD a0 = AreaInclusiveD.of(r0, r0);
    final AreaInclusiveD a1 = AreaInclusiveD.of(r1, r1);
    final AreaInclusiveD a2 = AreaInclusiveD.of(r0, r2);
    final AreaInclusiveD a3 = AreaInclusiveD.of(r0, r3);
    final AreaInclusiveD a4 = AreaInclusiveD.of(r2, r0);
    final AreaInclusiveD a5 = AreaInclusiveD.of(r3, r0);

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
    final RangeInclusiveD r0 = new RangeInclusiveD(0.0, 99.0);
    final RangeInclusiveD r1 = new RangeInclusiveD(0.0, 99.0);
    final RangeInclusiveD r2 = new RangeInclusiveD(0.0, 98.0);
    final RangeInclusiveD r3 = new RangeInclusiveD(1.0, 99.0);

    final AreaInclusiveD a0 = AreaInclusiveD.of(r0, r0);
    final AreaInclusiveD a1 = AreaInclusiveD.of(r1, r1);
    final AreaInclusiveD a2 = AreaInclusiveD.of(r0, r2);
    final AreaInclusiveD a3 = AreaInclusiveD.of(r0, r3);
    final AreaInclusiveD a4 = AreaInclusiveD.of(r2, r0);
    final AreaInclusiveD a5 = AreaInclusiveD.of(r3, r0);

    Assert.assertEquals((long) a0.hashCode(), (long) a0.hashCode());
    Assert.assertEquals((long) a0.hashCode(), (long) a1.hashCode());

    Assert.assertNotEquals((long) a0.hashCode(), (long) a2.hashCode());
    Assert.assertNotEquals((long) a0.hashCode(), (long) a3.hashCode());
    Assert.assertNotEquals((long) a0.hashCode(), (long) a4.hashCode());
    Assert.assertNotEquals((long) a0.hashCode(), (long) a5.hashCode());
  }

  @Test public void testAreaToString()
  {
    final RangeInclusiveD r0 = new RangeInclusiveD(0.0, 99.0);
    final RangeInclusiveD r1 = new RangeInclusiveD(0.0, 99.0);
    final RangeInclusiveD r2 = new RangeInclusiveD(0.0, 98.0);
    final RangeInclusiveD r3 = new RangeInclusiveD(1.0, 99.0);

    final AreaInclusiveD a0 = AreaInclusiveD.of(r0, r0);
    final AreaInclusiveD a1 = AreaInclusiveD.of(r1, r1);
    final AreaInclusiveD a2 = AreaInclusiveD.of(r0, r2);
    final AreaInclusiveD a3 = AreaInclusiveD.of(r0, r3);
    final AreaInclusiveD a4 = AreaInclusiveD.of(r2, r0);
    final AreaInclusiveD a5 = AreaInclusiveD.of(r3, r0);

    Assert.assertEquals(a0.toString(), a0.toString());
    Assert.assertEquals(a0.toString(), a1.toString());
    Assert.assertEquals(a1.toString(), a0.toString());

    Assert.assertNotEquals(a0.toString(), a2.toString());
    Assert.assertNotEquals(a0.toString(), a3.toString());
    Assert.assertNotEquals(a0.toString(), a4.toString());
    Assert.assertNotEquals(a0.toString(), a5.toString());
  }
}

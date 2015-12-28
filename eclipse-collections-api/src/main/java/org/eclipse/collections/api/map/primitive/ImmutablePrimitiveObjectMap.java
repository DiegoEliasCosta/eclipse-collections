/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.map.primitive;

import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableBooleanBag;
import org.eclipse.collections.api.bag.primitive.ImmutableByteBag;
import org.eclipse.collections.api.bag.primitive.ImmutableCharBag;
import org.eclipse.collections.api.bag.primitive.ImmutableDoubleBag;
import org.eclipse.collections.api.bag.primitive.ImmutableFloatBag;
import org.eclipse.collections.api.bag.primitive.ImmutableIntBag;
import org.eclipse.collections.api.bag.primitive.ImmutableLongBag;
import org.eclipse.collections.api.bag.primitive.ImmutableShortBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.multimap.bag.ImmutableBagMultimap;
import org.eclipse.collections.api.ordered.OrderedIterable;
import org.eclipse.collections.api.partition.bag.PartitionImmutableBag;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.tuple.Pair;

/**
 * @since 8.0.
 */
public interface ImmutablePrimitiveObjectMap<V> extends PrimitiveObjectMap<V>
{
    <K, VV> ImmutableMap<K, VV> aggregateInPlaceBy(Function<? super V, ? extends K> groupBy, Function0<? extends VV> zeroValueFactory, Procedure2<? super VV, ? super V> mutatingAggregator);

    <K, VV> ImmutableMap<K, VV> aggregateBy(Function<? super V, ? extends K> groupBy, Function0<? extends VV> zeroValueFactory, Function2<? super VV, ? super V, ? extends VV> nonMutatingAggregator);

    <VV> ImmutableBagMultimap<VV, V> groupByEach(Function<? super V, ? extends Iterable<VV>> function);

    <VV> ImmutableBagMultimap<VV, V> groupBy(Function<? super V, ? extends VV> function);

    <VV> ImmutableMap<VV, V> groupByUniqueKey(Function<? super V, ? extends VV> function);

    <VV> ImmutableBag<VV> collectIf(Predicate<? super V> predicate, Function<? super V, ? extends VV> function);

    <VV> ImmutableBag<VV> collect(Function<? super V, ? extends VV> function);

    <VV> ImmutableBag<VV> flatCollect(Function<? super V, ? extends Iterable<VV>> function);

    ImmutableBooleanBag collectBoolean(BooleanFunction<? super V> booleanFunction);

    ImmutableByteBag collectByte(ByteFunction<? super V> byteFunction);

    ImmutableCharBag collectChar(CharFunction<? super V> charFunction);

    ImmutableDoubleBag collectDouble(DoubleFunction<? super V> doubleFunction);

    ImmutableFloatBag collectFloat(FloatFunction<? super V> floatFunction);

    ImmutableIntBag collectInt(IntFunction<? super V> intFunction);

    ImmutableLongBag collectLong(LongFunction<? super V> longFunction);

    ImmutableShortBag collectShort(ShortFunction<? super V> shortFunction);

    <P, VV> ImmutableBag<VV> collectWith(Function2<? super V, ? super P, ? extends VV> function, P parameter);

    <S> ImmutableBag<S> selectInstancesOf(Class<S> clazz);

    ImmutableBag<V> select(Predicate<? super V> predicate);

    <P> ImmutableBag<V> selectWith(Predicate2<? super V, ? super P> predicate, P parameter);

    ImmutableBag<V> reject(Predicate<? super V> predicate);

    <P> ImmutableBag<V> rejectWith(Predicate2<? super V, ? super P> predicate, P parameter);

    PartitionImmutableBag<V> partition(Predicate<? super V> predicate);

    <P> PartitionImmutableBag<V> partitionWith(Predicate2<? super V, ? super P> predicate, P parameter);

    /**
     * @deprecated in 7.0. Use {@link OrderedIterable#zip(Iterable)} instead.
     */
    @Deprecated
    <S> ImmutableBag<Pair<V, S>> zip(Iterable<S> that);

    /**
     * @deprecated in 7.0. Use {@link OrderedIterable#zipWithIndex()} instead.
     */
    @Deprecated
    ImmutableSet<Pair<V, Integer>> zipWithIndex();
}

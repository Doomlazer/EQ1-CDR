;;; Sierra Script 1.0 - (do not remove this comment)
(script# 142)
(include sci.sh)
(use Main)
(use TilePiece)
(use n819)
(use EcoFeature)
(use EcoDialog)
(use RTRandCycle)
(use n958)
(use User)
(use Obj)

(public
	askRiddles 0
)

(local
	local0
)
(instance askRiddles of Script
	(properties)
	
	(method (init)
		(proc958_0 128 152 153 154)
		(super init: &rest)
		(proc0_1)
		(proc140_17 26 136)
		(gIconBar curIcon: (gIconBar at: 1))
		(proc0_2)
		(gIconBar disable: 5 0 3 4 5)
		(if (proc819_5 15) (gIconBar disable: 6))
		(User canInput: 1)
		(gEcoKeyDownHandler addToFront: self)
		(gEcoMouseDownHandler addToFront: self)
		((ScriptID 140 13) setCycle: 0 startUpd:)
	)
	
	(method (dispose)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(super dispose: &rest)
		(DisposeScript 142)
	)
	
	(method (changeState newState &tmp [temp0 500] temp500)
		(switch (= state newState)
			(0
				(if (proc819_5 30)
					((ScriptID 140 9) init: 2 0 0 23 1 self 140)
					(proc819_4 30)
				else
					(= cycles 1)
				)
			)
			(1
				(if (proc819_5 31)
					((ScriptID 140 9) init: 2 0 0 16 1 self 140)
					(proc819_4 31)
				else
					(= cycles 1)
				)
			)
			(2
				(if (gCast contains: bubble) (bubble dispose:))
				(switch global118
					(1
						((ScriptID 140 9) init: 2 0 0 7 1 self 140)
					)
					(2
						((ScriptID 140 9) init: 2 0 0 10 1 self 140)
					)
					(3
						((ScriptID 140 9) init: 2 0 0 11 1 self 140)
					)
					(4 (= state 6) (= cycles 1))
				)
			)
			(3
				(if (<= global118 3)
					(proc140_17 26 136)
					(Animate (gCast elements?) 0)
				)
				(Message msgGET 140 2 0 0 (* global118 4) @temp0)
				(proc821_1 @temp0 64 -1 10 111)
				(if (& global90 $0002)
					(= temp500 global90)
					(= global90 2)
					((ScriptID 140 9) init: 2 0 0 (* global118 4) 0 0 140)
					(= global90 temp500)
				)
			)
			(4
				(if (!= global118 local0)
					(= state 9)
					(= cycles 1)
				else
					(= cycles 1)
				)
			)
			(5
				(switch global118
					(1 (proc0_4 5 259))
					(2 (proc0_4 5 260))
					(3 (proc0_4 5 261))
				)
				(proc140_18)
				(bubble
					view: (+ 151 global118)
					loop: 0
					cel: 0
					x: (- 318 (CelWide (+ 151 global118) 0 0))
					y: 84
					setPri: 15
					init:
					stopUpd:
				)
				((ScriptID 140 9) init: 2 0 0 5 1 self 140)
			)
			(6
				(switch global118
					(1
						((ScriptID 140 9) init: 2 0 0 6 0 self 140)
					)
					(2
						((ScriptID 140 9) init: 2 0 0 9 0 self 140)
					)
					(3
						((ScriptID 140 9) init: 2 0 0 13 0 self 140)
						(proc819_3 4)
						(proc819_3 45)
					)
				)
				(++ global118)
				(= state 1)
			)
			(7
				((ScriptID 2 1) init: 1 0 0 5 1 self 140)
			)
			(8
				((ScriptID 140 9) init: 2 0 0 14 1 self 140)
			)
			(9 (= state 10) (= cycles 1))
			(10
				(proc819_3 31)
				((ScriptID 140 9) init: 2 0 0 15 1 self 140)
			)
			(11
				(self setScript: (ScriptID 140 16) self 1)
			)
			(12 (proc0_2) (self dispose:))
		)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(== state 3)
				(!= (pEvent type?) evVERB)
				(not
					(proc999_5
						(pEvent message?)
						9
						17
						15104
						15360
						16128
						16640
						17152
					)
				)
				(not (pEvent modifiers?))
			)
			(if gTheNewEcoDialog (gTheNewEcoDialog dispose:))
			(pEvent claimed: 1)
			(cond 
				((== (gIconBar curIcon?) (gIconBar at: 1))
					(switch (= local0 (proc140_19 pEvent))
						(1
							(EcoNarrator
								posn: -1 5
								talkWidth: -1
								init: 4 0 0 18 0 140
							)
						)
						(2
							(EcoNarrator
								posn: -1 5
								talkWidth: -1
								init: 4 0 0 19 0 140
							)
						)
						(3
							(EcoNarrator
								posn: -1 5
								talkWidth: -1
								init: 4 0 0 21 0 140
							)
						)
						(4
							(EcoNarrator
								posn: -1 5
								talkWidth: -1
								init: 4 0 0 22 0 140
							)
						)
						(5
							(EcoNarrator
								posn: -1 5
								talkWidth: -1
								init: 4 0 0 20 0 140
							)
						)
						(0
							(if
								(not
									(proc999_4
										((ScriptID 140 14) nsLeft?)
										((ScriptID 140 14) nsTop?)
										((ScriptID 140 15) nsRight?)
										((ScriptID 140 15) nsBottom?)
										pEvent
									)
								)
								(EcoNarrator init: 4 0 0 52 0 140)
							else
								(EcoNarrator init: 4 0 0 9 0 140)
							)
						)
					)
					(= state 2)
					(= cycles 3)
				)
				((== (gIconBar curIcon?) (gIconBar at: 2))
					(proc140_18)
					(= state 3)
					(switch (= local0 (proc140_19 pEvent))
						(1
							((ScriptID 2 1) init: 1 0 0 2 1 self 140)
						)
						(2
							((ScriptID 2 1) init: 1 0 0 3 1 self 140)
						)
						(3
							((ScriptID 2 1) init: 1 0 0 4 1 self 140)
						)
						(4
							((ScriptID 2 1) init: 1 0 0 8 1 self 140)
						)
						(5
							((ScriptID 2 1) init: 1 0 0 6 1 self 140)
						)
						(0
							(EcoNarrator
								posn: -1 5
								talkWidth: -1
								init: 4 0 0 42 self 140
							)
							(= state -1)
						)
					)
				)
			)
		else
			(super handleEvent: pEvent)
		)
	)
)

(instance bubble of EcoView
	(properties)
)

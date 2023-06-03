;;; Sierra Script 1.0 - (do not remove this comment)
(script# 65)
(include sci.sh)
(use Main)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use User)
(use Obj)

(public
	keyStuff 0
)

(local
	local0
	[local1 10]
	local11
	local12
)
(procedure (localproc_0044 param1)
	(= local12 1)
	(= [local1 local0] param1)
	(= local0 (mod (++ local0) 10))
	(= local12 0)
)

(procedure (localproc_005a)
	(= local12 1)
	(if (> local0 0)
		(return [local1 (-- local0)])
	else
		(return -1)
	)
	(return (= local12 0))
)

(procedure (localproc_0074 &tmp temp0)
	(d0 startUpd: setCel: 0)
	(d1 startUpd: setCel: 0)
	(d2 startUpd: setCel: 0)
	(d3 startUpd: setCel: 0)
	(cond 
		((>= (= temp0 local11) 1000)
			(d0 setCel: 2 setLoop: (/ temp0 1000))
			(= temp0 (- temp0 (* (/ temp0 1000) 1000)))
			(d1 setCel: 2 setLoop: (/ temp0 100))
			(= temp0 (- temp0 (* (/ temp0 100) 100)))
			(d2 setCel: 2 setLoop: (/ temp0 10))
			(= temp0 (- temp0 (* (/ temp0 10) 10)))
			(d3 setCel: 2 setLoop: temp0)
		)
		((>= temp0 100)
			(d0 setCel: 2 setLoop: (/ temp0 100))
			(= temp0 (- temp0 (* (/ temp0 100) 100)))
			(d1 setCel: 2 setLoop: (/ temp0 10))
			(= temp0 (- temp0 (* (/ temp0 10) 10)))
			(d2 setCel: 2 setLoop: temp0)
		)
		((>= temp0 10)
			(d0 setCel: 2 setLoop: (/ temp0 10))
			(= temp0 (- temp0 (* (/ temp0 10) 10)))
			(d1 setCel: 2 setLoop: temp0)
		)
		((>= temp0 1) (d0 setCel: 2 setLoop: temp0))
	)
)

(procedure (localproc_01e5 param1)
	(if (>= local11 1000) (= local11 0))
	(= local11 (+ (* local11 10) param1))
)

(procedure (localproc_01fd param1)
	(return
		(cond 
			((proc999_4 150 68 158 75 param1) (return 1))
			((proc999_4 159 68 167 75 param1) (return 2))
			((proc999_4 168 68 176 75 param1) (return 3))
			((proc999_4 150 76 158 83 param1) (return 4))
			((proc999_4 159 76 167 83 param1) (return 5))
			((proc999_4 168 76 176 83 param1) (return 6))
			((proc999_4 150 84 158 91 param1) (return 7))
			((proc999_4 159 84 167 91 param1) (return 8))
			((proc999_4 168 84 176 91 param1) (return 9))
			((proc999_4 150 92 158 99 param1) (return 10))
			((proc999_4 159 92 167 99 param1) (return 11))
			((proc999_4 168 92 176 99 param1) (return 0))
			(else (return -1))
		)
	)
)

(instance d0 of EcoProp
	(properties
		x 144
		y 55
		view 409
		priority 15
		signal $0010
	)
)

(instance d1 of EcoProp
	(properties
		x 152
		y 55
		view 409
		priority 15
		signal $0010
	)
)

(instance d2 of EcoProp
	(properties
		x 160
		y 55
		view 409
		priority 15
		signal $0010
	)
)

(instance d3 of EcoProp
	(properties
		x 168
		y 55
		view 409
		priority 15
		signal $0010
	)
)

(instance led of EcoProp
	(properties
		x 176
		y 55
		view 409
		loop 13
		priority 15
		signal $0010
	)
)

(instance tempKey of EcoProp
	(properties
		view 409
		cel 1
		priority 15
		signal $4010
	)
)

(instance keyPadView of EcoProp
	(properties
		x 163
		y 204
		z 100
		view 409
		loop 14
		priority 13
		signal $4010
		lookStr 79
	)
	
	(method (init)
		(super init:)
		(gEcoMouseDownHandler addToFront: self)
		(gEcoKeyDownHandler addToFront: self)
	)
	
	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (and (not script) local0 (not local12))
			(cond 
				((< (= temp0 (localproc_005a)) 10) (localproc_01e5 temp0) (self setScript: keyFlash 0 temp0))
				((== temp0 10) (self setScript: enterScript))
				((== temp0 11) (self setScript: clearScript))
			)
		)
	)
	
	(method (dispose)
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent &tmp temp0 temp1)
		(if (User controls?)
			(= temp1 (localproc_01fd pEvent))
			(cond 
				(
					(and
						(not (pEvent claimed?))
						(!= (pEvent type?) evVERB)
						(not (& (pEvent type?) $000a))
						(!= (pEvent message?) KEY_TAB)
						(not (self onMe: pEvent))
						(not (pEvent modifiers?))
					)
					(pEvent claimed: 1)
					(keyStuff cue:)
				)
				((= temp0 (pEvent message?))
					(cond 
						((and (== temp0 13) (!= temp1 -1)) (pEvent claimed: 1) (localproc_0044 temp1))
						((and (<= 48 temp0) (<= temp0 57))
							(pEvent claimed: 1)
							(localproc_0044 (- (pEvent message?) KEY_0))
						)
						((proc999_5 temp0 27 67 99) (pEvent claimed: 1) (localproc_0044 11))
						((proc999_5 temp0 69 101) (pEvent claimed: 1) (localproc_0044 10))
						((== temp0 4) (EcoNarrator posn: -1 140 init: 3 0 0 92 0 400))
						(else (super handleEvent: pEvent &rest))
					)
				)
				(
					(and
						(not (pEvent claimed?))
						(not (pEvent modifiers?))
						(!= (pEvent type?) evVERB)
						(not (& (pEvent type?) $000a))
						(== (gIconBar curIcon?) (gIconBar at: 1))
					)
					(pEvent claimed: 1)
					(EcoNarrator posn: -1 140 init: 3 0 0 lookStr)
				)
				(
					(and
						(not (pEvent claimed?))
						(not (pEvent modifiers?))
						(!= (pEvent type?) evVERB)
						(not (& (pEvent type?) $000a))
						(== (gIconBar curIcon?) (gIconBar at: 2))
						(!= temp1 -1)
					)
					(pEvent claimed: 1)
					(localproc_0044 temp1)
				)
				(else (super handleEvent: pEvent &rest))
			)
		else
			(super handleEvent: pEvent &rest)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(EcoNarrator posn: -1 140 init: 3 0 0 92 0 400)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance keyFlash of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state (= state newState))
			(0
				(if (proc999_5 register 0 10 11)
					(= temp0 93)
				else
					(= temp0 (+ (* (/ (- register 1) 3) 8) 69))
				)
				(cond 
					((== register 10) (= temp1 151))
					((== register 11) (= temp1 160))
					((not register) (= temp1 169))
					(else (= temp1 (+ (* (mod (- register 1) 3) 9) 151)))
				)
				(gSoundEffects number: (+ 903 register) loop: 1 play:)
				(tempKey
					startUpd:
					show:
					setLoop: register
					setCel: 1
					posn: temp1 temp0
				)
				(= ticks (= ticks 10))
			)
			(1
				(localproc_0074)
				(= ticks (= ticks 10))
			)
			(2
				(d0 stopUpd:)
				(d1 stopUpd:)
				(d2 stopUpd:)
				(d3 stopUpd:)
				(tempKey hide:)
				(self dispose:)
			)
		)
	)
)

(instance keyStuff of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 20])
		(switch (= state (= state newState))
			(0
				(keyPadView init: stopUpd:)
				(proc819_3 14)
				(proc0_2)
				(gIconBar disable: 5 0 3 4 5 6)
				(d0 init: stopUpd:)
				(d1 init: stopUpd:)
				(d2 init: stopUpd:)
				(d3 init: stopUpd:)
				(gEgo stopUpd:)
				((ScriptID 400 3) stopUpd:)
				((ScriptID 400 7) stopUpd:)
				(tempKey init: hide:)
			)
			(1
				(keyPadView startUpd: hide:)
				(d0 startUpd: hide:)
				(d1 startUpd: hide:)
				(d2 startUpd: hide:)
				(d3 startUpd: hide:)
				(tempKey startUpd: hide:)
				(= ticks (= ticks 6))
			)
			(2
				(d0 dispose: delete:)
				(d1 dispose: delete:)
				(d2 dispose: delete:)
				(d3 dispose: delete:)
				(gEgo startUpd:)
				((ScriptID 400 3) startUpd:)
				(if (not (proc819_5 69)) ((ScriptID 400 7) startUpd:))
				(tempKey dispose: delete:)
				(if (keyPadView script?)
					((keyPadView script?) dispose:)
				)
				(keyPadView dispose: delete:)
				(gGame setCursor: ((gIconBar curIcon?) cursor?))
				(= cycles (= cycles 3))
			)
			(3
				(self dispose: &rest)
				(DisposeScript 65)
			)
		)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gSoundEffects number: 913 loop: 1 play:)
				(tempKey show: setLoop: 10 setCel: 1 posn: 151 93)
				(= cycles (= cycles 2))
			)
			(1
				(tempKey hide:)
				(d0 setLoop: 12 cel: 1)
				(d1 setCel: 0)
				(d2 setCel: 0)
				(d3 setCel: 0)
				(led cel: (if (== local11 9731) 2 else 1) init:)
				(= register (= register 5))
				(= cycles (= cycles 1))
			)
			(2
				(gSoundEffects
					number: (+ 931 (!= local11 9731))
					loop: 1
					play:
				)
				(led show:)
				(= ticks (= ticks 15))
			)
			(3
				(if (-- register) (= state (= state (- state 2))))
				(led hide:)
				(= ticks (= ticks 15))
			)
			(4
				(if (== local11 9731)
					(proc819_4 14)
					(keyStuff cue:)
					(d0 setLoop: 0 cel: 0)
					(led dispose:)
					(self dispose:)
				else
					(EcoNarrator posn: -1 140 init: 3 0 0 85 self 400)
				)
			)
			(5
				(proc819_3 14)
				(= local11 0)
				(= local0 0)
				(proc0_2)
				(gIconBar disable: 5 0 3 4 5 6)
				(d0 setLoop: 0 cel: 0)
				(led dispose:)
				(self dispose:)
			)
		)
	)
)

(instance clearScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state (= state newState))
			(0
				(proc0_1)
				(gSoundEffects number: 914 loop: 1 play:)
				(tempKey show: setLoop: 11 setCel: 1 posn: 160 93)
				(= cycles (= cycles 2))
			)
			(1
				(tempKey hide:)
				(d0 setLoop: 12 cel: 0)
				(d1 setCel: 0)
				(d2 setCel: 0)
				(d3 setCel: 0)
				(= register (= register 5))
				(= cycles (= cycles 1))
			)
			(2
				(d0 hide:)
				(= cycles (= cycles 2))
			)
			(3
				(if (-- register) (= state (= state (- state 2))))
				(d0 show:)
				(= cycles (= cycles 2))
			)
			(4
				(d0 setLoop: 0 cel: 0)
				(= local11 0)
				(= local0 0)
				(proc0_2)
				(gIconBar disable: 5 0 3 4 5 6)
				(self dispose:)
			)
		)
	)
)
